package br.each.usp.bankusp.repositorios;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDePagamentos;
import br.each.usp.bankusp.representacoes.Pagamento;

@Component
public class RepositorioDePagamentosPersistente implements	RepositorioDePagamentos {
	
	private final Session session;

	public RepositorioDePagamentosPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public void grava(final Pagamento pagamento) {
		this.session.save(pagamento);
	}

}
