package br.each.usp.bankusp.repositorios;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAdministradores;
import br.each.usp.bankusp.representacoes.Administrador;

@RunWith(JMock.class)
public class RepositorioDeAdministradoresPersistenteDeveria {

	private final Mockery contexto = new Mockery();
	private final Session session = contexto.mock(Session.class);
	private final Query query = contexto.mock(Query.class);
	private final RepositorioDeAdministradores repositorioDeAdministradores = new RepositorioDeAdministradoresPersistente(session);

	@Test
	public void delegarPersistenciaDeObjetoParaOFrameworkDePersistencia() throws Exception {
		final Administrador administradorConhecido = Um.Administrador().novo();
		contexto.checking(new Expectations(){{
			one(session).save(administradorConhecido);
		}});
		repositorioDeAdministradores.grava(administradorConhecido);
	}
	
	@Test
	public void informarInexistenciaDeUmAdministradorEncontradoNoBancoDeDados() throws Exception {
		final String loginConhecido = "um login qualquer";
		final Administrador administradorAConsultar = Um.Administrador().doLogin(loginConhecido).novo();		
		final Administrador administradorInexistenteNoBancoDeDados = null;
		final String consultaHQLConhecida = "from Administrador where login = :login";
		contexto.checking(new Expectations(){{
			allowing(session).createQuery(consultaHQLConhecida);
			will(returnValue(query));
			allowing(query).setParameter("login", loginConhecido);
			will(returnValue(query));
			allowing(query).uniqueResult();
			will(returnValue(administradorInexistenteNoBancoDeDados));
		}});
		final boolean existeAdministrador = repositorioDeAdministradores.existeAdministrador(administradorAConsultar);
		assertThat(existeAdministrador, is(false));
	}	
	
	@Test
	public void informarExistenciaDeUmAdministradorEncontradoNoBancoDeDados() throws Exception {
		final String loginConhecido = "um login qualquer";
		final Administrador administradorAConsultar = Um.Administrador().doLogin(loginConhecido).novo();		
		final Administrador administradorExistenteNoBancoDeDados = Um.Administrador().novo();
		final String consultaHQLConhecida = "from Administrador where login = :login";
		contexto.checking(new Expectations(){{
			allowing(session).createQuery(consultaHQLConhecida);
			will(returnValue(query));
			allowing(query).setParameter("login", loginConhecido);
			will(returnValue(query));
			allowing(query).uniqueResult();
			will(returnValue(administradorExistenteNoBancoDeDados));
		}});
		final boolean existeAdministrador = repositorioDeAdministradores.existeAdministrador(administradorAConsultar);
		assertThat(existeAdministrador, is(true));		
	}
	
}
