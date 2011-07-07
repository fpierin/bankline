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

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeClientes;
import br.each.usp.bankusp.representacoes.Cliente;

@RunWith(JMock.class)
public class RepositorioDeClientesPersistenteDeveria {

	private final Mockery contexto = new Mockery();
	private final Query query = contexto.mock(Query.class);
	private final Session session = contexto.mock(Session.class);
	
	private final RepositorioDeClientes repositorioDeClientes = new RepositorioDeClientesPersistente(session);
	
	@Test
	public void deveriaInvocarUmaHQLConhecidaParaBuscarUmClientePeloIdConhecido() throws Exception {
		final int id = 2176412;
		final String consultaHQLEsperada = "from Cliente as cliente" +
										   " where cliente.id = :id";
		final Cliente clienteEsperado = Um.Cliente().deId(id).novo();
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaHQLEsperada);
			will(returnValue(query));
			one(query).setParameter("id", id);
			will(returnValue(query));	
			one(query).uniqueResult();
			will(returnValue(clienteEsperado));
		}});
		repositorioDeClientes.buscaCliente(id);
	}
	
	@Test
	public void delegarParaASessaoDoHibernateAoGravarUmClienteConhecido() throws Exception {
		final Cliente clienteConhecido = Um.Cliente().deId(7).novo();
		contexto.checking(new Expectations(){{
			one(session).save(clienteConhecido);
		}});		
		repositorioDeClientes.grava(clienteConhecido);
	}
	
	@Test
	public void consutlaUmaHQLConhecidaParaListarTodosOsClientesDoSistema() throws Exception {
		final List<Cliente> clientesConhecidos = new ArrayList<Cliente>();
		final String consultaHQLEsperada = "from Cliente";
		contexto.checking(new Expectations(){{
			one(session).createQuery(consultaHQLEsperada);
			will(returnValue(query));
			one(query).list();
			will(returnValue(clientesConhecidos));
		}});				
		repositorioDeClientes.listarClientes();
	}
	
	@Test
	public void realizarUmUpdateNoHibernateDeUmClienteConhecido() throws Exception {
		final Cliente clienteConhecido = Um.Cliente().novo();
		contexto.checking(new Expectations(){{
			one(session).update(clienteConhecido);
		}});
		repositorioDeClientes.atualiza(clienteConhecido);
	}
	
}
