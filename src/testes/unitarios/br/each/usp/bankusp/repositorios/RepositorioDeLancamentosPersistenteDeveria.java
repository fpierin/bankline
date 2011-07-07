package br.each.usp.bankusp.repositorios;

import org.hibernate.Session;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.representacoes.Lancamento;

@RunWith(JMock.class)
public class RepositorioDeLancamentosPersistenteDeveria {
	
	private final Mockery contexto = new Mockery();
	private final Session session = contexto.mock(Session.class);
	private final RepositorioDeLancamentos repositorioDeLancamentos = new RepositorioDeLancamentosPersistente(session);
	
	@Test
	public void gravarUmLancamentoConhecido() throws Exception {
		final Lancamento lancamento = Um.Lancamento().novo();
		contexto.checking(new Expectations(){{
			one(session).save(lancamento);
		}});
		repositorioDeLancamentos.grava(lancamento);
	}

}
