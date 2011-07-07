package br.each.usp.bankusp.repositorios;

import org.hibernate.Session;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDePagamentos;
import br.each.usp.bankusp.representacoes.Pagamento;

public class RepositorioDePagamentosPersistenteDeveria {

	private final Mockery contexto = new Mockery();
	private final Session session = contexto.mock(Session.class);
	private final RepositorioDePagamentos repositorioDePagamentos = new RepositorioDePagamentosPersistente(session);
	
	@Test
	public void delegarParaOFrameworkAPersistenciaDeUmPagamentoNoBancoDeDados() throws Exception {
		final Pagamento pagamento = Um.Pagamento().novo();
		contexto.checking(new Expectations(){{
			one(session).save(pagamento);
		}});
		repositorioDePagamentos.grava(pagamento);
	}

}
