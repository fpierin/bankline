package br.each.usp.bankusp.repositorios;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAdministradores;
import br.each.usp.bankusp.representacoes.Administrador;
import br.each.usp.bankusp.representacoes.Taxas;

@Component
public class RepositorioDeAdministradoresPersistente implements RepositorioDeAdministradores {
	
	private final Session session;

	public RepositorioDeAdministradoresPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public boolean existeAdministrador(final Administrador administrador) {
		final Administrador uniqueResult = (Administrador) session.createQuery("from Administrador where login = :login")
						   			   .setParameter("login", administrador.getLogin())
						   			   .uniqueResult();
		return (uniqueResult != null);
	}

	@Override
	public void grava(final Administrador administrador) {
		session.save(administrador);
	}

	@Override
	public Taxas obterTaxas() {
		return (Taxas) session.createQuery("from Taxas where id = :id").setParameter("id", 1).uniqueResult();
	}

	@Override
	public void save(final Taxas taxa) {
		session.saveOrUpdate(taxa);
	}

}
