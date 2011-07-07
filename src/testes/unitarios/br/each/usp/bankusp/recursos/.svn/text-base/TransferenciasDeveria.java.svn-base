package br.each.usp.bankusp.recursos;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.construtores.Uma;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Sessao;
import br.each.usp.bankusp.representacoes.Transferencia;

@RunWith(JMock.class)
public class TransferenciasDeveria {

	// Objeto gerador de Stubs de classes;
	private final Mockery contexto = new Mockery();

	// Stubs de classes;	
	private final Sessao sessao = contexto.mock(Sessao.class);
	private final Validator validator = contexto.mock(Validator.class);
	private final RepositorioDeLancamentos repositorioDeLancamentos = contexto.mock(RepositorioDeLancamentos.class);
	private final RepositorioDeContas repositorioDeContas = contexto.mock(RepositorioDeContas.class);
	private final Result result = contexto.mock(Result.class);
	
	// Objeto da classe em teste;	
	private final TransferenciasController controladorDeTransferencias 
		= new TransferenciasController(result, repositorioDeContas, repositorioDeLancamentos, sessao, validator);
	
	@Before
	public void permitindoUtilizacaoDeStubDeUmaClasseConcreta() throws Exception {
		contexto.setImposteriser(ClassImposteriser.INSTANCE);
	}
	
	@Test
	public void transferirRequisicaoDeSessaoNaoLogadaParaTelaDeLogin() throws Exception {
		final Bankline controllerDoBankline = contexto.mock(Bankline.class);

		contexto.checking(new Expectations(){{
			one(sessao).isLogada();
			will(returnValue(true));
			one(result).redirectTo(Bankline.class);
			will(returnValue(controllerDoBankline));
			one(controllerDoBankline).login();
		}});
		
		controladorDeTransferencias.realizarTransferencia(null);
	}
	
	@Test
	public void recarregarAPaginaDeTransferenciaAcusandoErroQuandoUmaTransferenciaForRealizadaParaAPropriaConta() throws Exception {
		final double valorConhecido = 1500.00;
		final String contaConhecida = "11122";
		final String agenciaConhecida = "3344";
		
		final Transferencia transferencia = Uma.Transferencia()
											   .de(valorConhecido)
											   .paraConta(contaConhecida)
											   .daAgencia(agenciaConhecida).nova();

		final Conta contaLogada = Uma.Conta().daAgenciaDeCodigo(agenciaConhecida).daContaDeCodigo(contaConhecida).nova();
		
		final TransferenciasController acoesDeTransferencias = contexto.mock(TransferenciasController.class);
		
		contexto.checking(new Expectations(){{
			allowing(sessao).isLogada();
			will(returnValue(true));
			
			allowing(validator).add(with(any(ValidationMessage.class)));
			
			one(sessao).getContaLogada();
			will(returnValue(contaLogada));
			
			one(validator).onErrorUsePageOf(TransferenciasController.class);
			
			will(returnValue(acoesDeTransferencias));
			one(acoesDeTransferencias).index();
		}});
		
		controladorDeTransferencias.realizarTransferencia(transferencia);
	}	
	
	@Test
	public void recarregarAPaginaDeTransferenciaAcusandoErroQuandoUmaTransferenciaForRealizadaParaUmaContaInexistente() throws Exception {
		final double valorConhecido = 7200.00;
		final String contaConhecida = "11122";
		final String agenciaConhecida = "3344";
		
		final String contaDesconhecida = "42455";
		final String agenciaDesconhecida = "0008";
		
		final Transferencia transferencia = Uma.Transferencia()
											   .de(valorConhecido)
											   .paraConta(contaDesconhecida)
											   .daAgencia(agenciaDesconhecida).nova();

		final Conta contaLogada = Uma.Conta().daAgenciaDeCodigo(agenciaConhecida).daContaDeCodigo(contaConhecida).nova();
		final Conta umaContaInexistente = null;		
		
		final TransferenciasController acoesDeTransferencias = contexto.mock(TransferenciasController.class);
		
		contexto.checking(new Expectations(){{
			allowing(sessao).isLogada();
			will(returnValue(true));
			
			allowing(validator).add(with(any(ValidationMessage.class)));
			
			one(sessao).getContaLogada();
			will(returnValue(contaLogada));
			
			one(repositorioDeContas).carrega(agenciaDesconhecida, contaDesconhecida);
			will(returnValue(umaContaInexistente));
			
			one(validator).onErrorUsePageOf(TransferenciasController.class);
			
			will(returnValue(acoesDeTransferencias));
			one(acoesDeTransferencias).index();
		}});
		
		controladorDeTransferencias.realizarTransferencia(transferencia);
	}		
	
	@Test
	public void recarregarAPaginaDeContaCorrenteAoPersistirOsLancamentosFinanceirorRealizandoUmaTransferenciaComSucesso() throws Exception {
		final double valorConhecido = 7200.00;
		final String contaConhecida = "11122";
		final String agenciaConhecida = "3344";
		
		final String contaAlvoConhecida = "42455";
		final String agenciaAlvoConhecida = "0008";
		
		final Transferencia transferencia = Uma.Transferencia()
											   .de(valorConhecido)
											   .paraConta(contaAlvoConhecida)
											   .daAgencia(agenciaAlvoConhecida).nova();

		final Conta contaLogada = Uma.Conta().daAgenciaDeCodigo(agenciaConhecida).daContaDeCodigo(contaConhecida).nova();
		final Conta umaContaReal = Uma.Conta().nova();		
		
		final ContasController contaCorrente = contexto.mock(ContasController.class);
		final TransferenciasController stubDeTransferencia = contexto.mock(TransferenciasController.class);
		
		contexto.checking(new Expectations(){{
			allowing(sessao).isLogada();
			will(returnValue(true));
			
			never(validator).add(with(any(ValidationMessage.class)));
			
			one(sessao).getContaLogada();
			will(returnValue(contaLogada));
			
			one(repositorioDeContas).carrega(agenciaAlvoConhecida, contaAlvoConhecida);
			will(returnValue(umaContaReal));
			
			allowing(validator).onErrorUsePageOf(TransferenciasController.class);
			will(returnValue(stubDeTransferencia));
			allowing(stubDeTransferencia).index();
			
			oneOf(repositorioDeLancamentos).grava(with(any(Lancamento.class)));
			oneOf(repositorioDeLancamentos).grava(with(any(Lancamento.class)));			
			
			one(result).redirectTo(ContasController.class);
			will(returnValue(contaCorrente));
			one(contaCorrente).extrato();
			
		}});
		
		controladorDeTransferencias.realizarTransferencia(transferencia);
	}			
	
	

}
