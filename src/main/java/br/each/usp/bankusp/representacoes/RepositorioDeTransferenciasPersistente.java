package br.each.usp.bankusp.representacoes;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeTransferencias;

@Component
public class RepositorioDeTransferenciasPersistente implements RepositorioDeTransferencias {

	private final Session session;

	public RepositorioDeTransferenciasPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public void grava(final Transferencia transferencia) {
		session.save(transferencia);
	}
	

}
