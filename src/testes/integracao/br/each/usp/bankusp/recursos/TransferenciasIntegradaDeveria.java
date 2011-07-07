package br.each.usp.bankusp.recursos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.construtores.Uma;
import br.each.usp.bankusp.fabricas.FabricaDeSessionFactory;
import br.each.usp.bankusp.leitores.LeitorDePropriedadesDeConfiguracaoDoBancoDeDados;
import br.each.usp.bankusp.modelo.leitores.LeitorDePropriedadesDeConfiguracao;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeClientes;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.repositorios.RepositorioDeClientesPersistente;
import br.each.usp.bankusp.repositorios.RepositorioDeContasPersistente;
import br.each.usp.bankusp.repositorios.RepositorioDeLancamentosPersistente;
import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Sessao;
import br.each.usp.bankusp.representacoes.Transferencia;
import br.each.usp.bankusp.utils.Transactor;

@RunWith(JMock.class)
public class TransferenciasIntegradaDeveria {
	
	// Classe geradora de stubs de teste
	private final Mockery contexto = new Mockery();
	
	// Faz parte de um outro framework que não precisa ser testado, afinal, não é o foco dessa integração
	private final Result result = contexto.mock(Result.class);
	private final Validator validator = contexto.mock(Validator.class);	
	
	// Classes utilizadas durante o teste;
	private RepositorioDeContas repositorioDeContas;
	private RepositorioDeClientes repositorioDeClientes;	
	private RepositorioDeLancamentos repositorioDeLancamentos;
	private SessionFactory sessionFactory;
	private Sessao sessao;
	
	// Classe foco do teste de integração com banco de dados
	private TransferenciasController controladorDeTransferencias;
	
	private Conta contaDebitada;
	private Conta contaCreditada;
	
	private final String codigoDaContaCreditada = "77777";
	private final String codigoDaAgenciaCreditada = "4444";
	
	private final String codigoDaContaDebitada = "88888";
	private final String codigoDaAgenciaDebitada = "5555";
	
	@Before
	public void incluindoApenasAsInformacoesDeContasNecessariasParaOTeste() throws Exception {
		new Transactor<Void>(sessionFactory) {

			@Override
			public Void dentroDeUmaTransacao(final Session session) {

				repositorioDeClientes = new RepositorioDeClientesPersistente(session);
				repositorioDeContas = new RepositorioDeContasPersistente(session);
				
				final Cliente clienteDaContaCreditada = Um.Cliente().deNome("Cliente creditado").novo();
				final Cliente clienteDaContaDebitada = Um.Cliente().deNome("Cliente debitado").novo();
				
				contaDebitada = Uma.Conta().doCliente(clienteDaContaDebitada).daAgenciaDeCodigo(codigoDaAgenciaDebitada)
										   .daContaDeCodigo(codigoDaContaDebitada).nova();
				
				contaCreditada = Uma.Conta().doCliente(clienteDaContaCreditada).daAgenciaDeCodigo(codigoDaAgenciaCreditada)
											.daContaDeCodigo(codigoDaContaCreditada).nova();
				
				repositorioDeClientes.grava(clienteDaContaCreditada);
				repositorioDeClientes.grava(clienteDaContaDebitada);
				
				repositorioDeContas.grava(contaCreditada);
				repositorioDeContas.grava(contaDebitada);				
				return null;
			}
		}.go();
	}
	
	@Before
	public void aposApagarTodosOsRegistrosDoBancoDeDados() throws Exception {
		new Transactor<Void>(sessionFactory) {
			@Override
			public Void dentroDeUmaTransacao(final Session session) {
				session.createQuery("delete from Cliente").executeUpdate();				
				session.createQuery("delete from Lancamento").executeUpdate();				
				session.createQuery("delete from Conta").executeUpdate();
				return null;
			}
		}.go();		
	}
	
	@Before
	public void partindoDeUmaConexaoDeTestesComOBancoDeDados() throws Exception {
		final LeitorDePropriedadesDeConfiguracao leitorDePropriedades = new LeitorDePropriedadesDeConfiguracaoDoBancoDeDados();
		final FabricaDeSessionFactory fabricaDeSessionFactory = new FabricaDeSessionFactory(leitorDePropriedades);
		this.sessionFactory = fabricaDeSessionFactory.build();
	}
	
	@Before
	public void permitindoRedirecionamentoDeResultadoParaUmStubDeControleDeContaCorrente(){
		contexto.setImposteriser(ClassImposteriser.INSTANCE);
	}
			
	@Test
	public void debitarUmaValorConhecidoDeUmaContaExistenteNoBancoDeDados() throws Exception {

		final ContasController stubDeUmaContaCorrente = contexto.mock(ContasController.class);
		final TransferenciasController stubDeUmaClasseDeTransferenciasQualquer = contexto.mock(TransferenciasController.class);
		
		final double valorConhecido = 1020.0;

		final double saldoAntesDaTransferencia = 
			new Transactor<Double>(sessionFactory) {
				@Override
				public Double dentroDeUmaTransacao(Session session) {
					repositorioDeContas = new RepositorioDeContasPersistente(session);					
					return repositorioDeContas.carrega(codigoDaAgenciaDebitada, codigoDaContaDebitada).getSaldoTotal();
				}
			}.go();
			
		
		new Transactor<Void>(sessionFactory) {
			@Override
			public Void dentroDeUmaTransacao(final Session session) {
				
				contexto.checking(new Expectations(){{
					allowing(result).redirectTo(ContasController.class);
					will(returnValue(stubDeUmaContaCorrente));
					allowing(stubDeUmaContaCorrente).extrato();
					allowing(validator).onErrorUsePageOf(TransferenciasController.class);
					will(returnValue(stubDeUmaClasseDeTransferenciasQualquer));
					allowing(stubDeUmaClasseDeTransferenciasQualquer).index();
				}});
				

				final Transferencia transferencia = Uma.Transferencia().de(valorConhecido)
																	   .paraConta(codigoDaContaCreditada)
																	   .daAgencia(codigoDaAgenciaCreditada).nova();
				
				sessao = new Sessao();
				sessao.login(contaDebitada);
				
				repositorioDeContas = new RepositorioDeContasPersistente(session);
				repositorioDeLancamentos = new RepositorioDeLancamentosPersistente(session);
				
				controladorDeTransferencias = new TransferenciasController(result, repositorioDeContas, repositorioDeLancamentos, sessao, validator);

				controladorDeTransferencias.realizarTransferencia(transferencia);
				
				
				return null;
			}
		}.go();
		
		final double saldoAposTransferencia = 
			new Transactor<Double>(sessionFactory) {
				@Override
				public Double dentroDeUmaTransacao(Session session) {
					repositorioDeContas = new RepositorioDeContasPersistente(session);
					return repositorioDeContas.carrega(codigoDaAgenciaDebitada, codigoDaContaDebitada).getSaldoTotal();
				}
			}.go();
			
		assertThat(saldoAposTransferencia, is(saldoAntesDaTransferencia - valorConhecido));
		
	}
	
	@Test
	public void creditarUmaValorConhecidoAUmaContaExistenteNoBancoDeDados() throws Exception {
		
		final ContasController stubDeUmaContaCorrente = contexto.mock(ContasController.class);
		final TransferenciasController stubDeUmaClasseDeTransferenciasQualquer = contexto.mock(TransferenciasController.class);
		
		final double valorConhecido = 1020.0;

		final double saldoAntesDaTransferencia = 
			new Transactor<Double>(sessionFactory) {
				@Override
				public Double dentroDeUmaTransacao(Session session) {
					repositorioDeContas = new RepositorioDeContasPersistente(session);					
					return repositorioDeContas.carrega(codigoDaAgenciaCreditada, codigoDaContaCreditada).getSaldoTotal();
				}
			}.go();
			
		
		new Transactor<Void>(sessionFactory) {
			@Override
			public Void dentroDeUmaTransacao(final Session session) {
				
				contexto.checking(new Expectations(){{
					allowing(result).redirectTo(ContasController.class);
					will(returnValue(stubDeUmaContaCorrente));
					allowing(stubDeUmaContaCorrente).extrato();
					allowing(validator).onErrorUsePageOf(TransferenciasController.class);
					will(returnValue(stubDeUmaClasseDeTransferenciasQualquer));
					allowing(stubDeUmaClasseDeTransferenciasQualquer).index();
				}});
				

				final Transferencia transferencia = Uma.Transferencia().de(valorConhecido)
																	   .paraConta(codigoDaContaCreditada)
																	   .daAgencia(codigoDaAgenciaCreditada).nova();
				
				sessao = new Sessao();
				sessao.login(contaDebitada);
				
				repositorioDeContas = new RepositorioDeContasPersistente(session);
				repositorioDeLancamentos = new RepositorioDeLancamentosPersistente(session);
				
				controladorDeTransferencias = new TransferenciasController(result, repositorioDeContas, repositorioDeLancamentos, sessao, validator);

				controladorDeTransferencias.realizarTransferencia(transferencia);
				
				
				return null;
			}
		}.go();
		
		final double saldoAposTransferencia = 
			new Transactor<Double>(sessionFactory) {
				@Override
				public Double dentroDeUmaTransacao(Session session) {
					repositorioDeContas = new RepositorioDeContasPersistente(session);
					return repositorioDeContas.carrega(codigoDaAgenciaCreditada, codigoDaContaCreditada).getSaldoTotal();
				}
			}.go();
			
		assertThat(saldoAposTransferencia, is(saldoAntesDaTransferencia + valorConhecido));		
	}	
}

























