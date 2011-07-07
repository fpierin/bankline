package br.each.usp.bankusp.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.each.usp.bankusp.construtores.Uma;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

@RunWith(JMock.class)
public class RepositorioDeContasPersistenteDeveria {
	
	final Mockery contexto = new Mockery();
	final Session session = contexto.mock(Session.class);
	final Query query = contexto.mock(Query.class);
	final RepositorioDeContas repositorioDeContas = new RepositorioDeContasPersistente(session);
	
	@Test
	public void usarUmaHQLConhecidaParaCarregarUmaContaPartindoDeUmCodigoDeAgenciaEDeUmCodigoDeContaConhecidos() throws Exception {
		final Conta contaEsperada = Uma.Conta().nova();
		final String codigoDaConta = "241";
		final String codigoDaAgencia = "jkdhsa";
		final String consultaConhecida = "from Conta" +
   									   " where codigoDaAgencia = :codigoDaAgencia" +
										 " and codigoDaConta = :codigoDaConta";
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaConhecida);
			will(returnValue(query));
			one(query).setParameter("codigoDaAgencia", codigoDaAgencia);
			will(returnValue(query));
			one(query).setParameter("codigoDaConta", codigoDaConta);
			will(returnValue(query));
			one(query).uniqueResult();
			will(returnValue(contaEsperada));
		}});
		repositorioDeContas.carrega(codigoDaAgencia, codigoDaConta);
	}
	
	@Test
	public void usarUmaHQLConhecidaAoListarAsContasCadastradasNoSistema() throws Exception {
		final String consultaConhecida = "from Conta as conta" +
								  " inner join fetch conta.cliente as cliente";
		
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaConhecida);
			will(returnValue(query));
			one(query).list();			
		}});
		
		repositorioDeContas.listarContas();		
	}

	@Test
	public void usarUmaHQLConhecidaParaListarAsMovimentacoesDaConta() throws Exception {
		final List<Lancamento> lancamentosConhecidos = new ArrayList<Lancamento>();
		final Conta contaConhecida = Uma.Conta().nova();
		final String consultaConhecida = "from Lancamento where conta = :conta";
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaConhecida);
			will(returnValue(query));
			one(query).setParameter("conta", contaConhecida);
			will(returnValue(query));			
			one(query).list();
			will(returnValue(lancamentosConhecidos));
		}});
		repositorioDeContas.listaMovimentacaoDaConta(contaConhecida);
	}
	
	@Test
	public void carregarUmaContaComSenhaAgenciaECodigoDeContaConhecidos() throws Exception {
		final String codigoDaAgencia = "codigo da agencia qualquer";
		final String codigoDaConta = "codigo da conta qualquer";		
		final String senha = "senha conhecida";
		final Conta contaConhecida = Uma.Conta().daAgenciaDeCodigo(codigoDaAgencia)
												.daContaDeCodigo(codigoDaConta)
												.protegidaPelaSenha(senha ).nova();
		final String consultaConhecida = "from Conta" +
									   " where codigoDaAgencia = :codigoDaAgencia" +
										 " and codigoDaConta = :codigoDaConta" +
										 " and senha = :senha";
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaConhecida);
			will(returnValue(query));
			one(query).setParameter("codigoDaAgencia", codigoDaAgencia);
			will(returnValue(query));
			one(query).setParameter("codigoDaConta", codigoDaConta);
			will(returnValue(query));
			one(query).setParameter("senha", senha);
			will(returnValue(query));						
			one(query).uniqueResult();
			will(returnValue(contaConhecida));
		}});
		repositorioDeContas.carrega(contaConhecida);		
	}
	
	@Test
	public void persistirUmaContaConhecidaNoBancoDeDadosAoAdicionala() throws Exception {
		final Conta contaConhecida = Uma.Conta().nova();
		contexto.checking(new Expectations(){{
			one(session).save(contaConhecida);
		}});
		repositorioDeContas.adiciona(contaConhecida);
	}
	
	@Test
	public void delegarPersistenciaDeContaConhecidaAoFrameworkDePersistencia() throws Exception {
		final Conta contaConhecida = Uma.Conta().nova();
		contexto.checking(new Expectations(){{
			one(session).save(contaConhecida);
		}});		
		repositorioDeContas.grava(contaConhecida);
	}
	
	@Test
	public void carregarDeUmHQLConhecidoUmaContaComLancamentos() throws Exception {
		final String consultaConhecida = "from Conta as conta" +
								 " inner join fetch conta.lancamentos as lancamento" +
								 " where conta = :conta";
		final Conta contaConhecida = Uma.Conta().nova();
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaConhecida);
			will(returnValue(query));
			one(query).setParameter("conta", contaConhecida);
			will(returnValue(query));
			one(query).uniqueResult();
			will(returnValue(contaConhecida));
		}});
		repositorioDeContas.carregaContaComLancamentos(contaConhecida);		
	}

}
