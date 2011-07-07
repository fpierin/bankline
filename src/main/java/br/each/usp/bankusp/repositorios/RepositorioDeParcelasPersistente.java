package br.each.usp.bankusp.repositorios;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeParcelas;
import br.each.usp.bankusp.representacoes.Parcela;

@Component
public class RepositorioDeParcelasPersistente implements RepositorioDeParcelas {
	
	private final Session session;

	public RepositorioDeParcelasPersistente(final Session session){
		this.session = session;
	}

	@Override
	public Parcela obterParcela(final int id) {
		return (Parcela) session.createQuery("from Parcela where id = :id")
								  .setParameter("id", id).uniqueResult();
		
	}

	@Override
	public void atualiza(final Parcela parcela) {
		session.update(parcela);
	}

}
