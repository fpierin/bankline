package br.each.usp.bankusp.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeClientes;
import br.each.usp.bankusp.representacoes.Cliente;

@Component
public class RepositorioDeClientesPersistente implements RepositorioDeClientes {

	private final Session session;

	public RepositorioDeClientesPersistente(final Session session) {
		this.session = session;
	}

	public Cliente buscaCliente(final int id) {
		return (Cliente) session.createQuery("from Cliente as cliente" +
										   " where cliente.id = :id")
								.setParameter("id", id)
								.uniqueResult();
	}

	public void grava(final Cliente cliente) {
		session.save(cliente);
	}

	@Override
	public void atualiza(final Cliente cliente) {
		session.update(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarClientes() {
		return (List<Cliente>) session.createQuery("from Cliente").list();
	}

	@Override
	public void excluirCliente(final Cliente cliente) {
		session.delete(cliente);
	}

}
