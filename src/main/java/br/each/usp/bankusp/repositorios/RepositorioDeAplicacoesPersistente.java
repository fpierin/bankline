package br.each.usp.bankusp.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAplicacoes;
import br.each.usp.bankusp.representacoes.Aplicacao;
import br.each.usp.bankusp.representacoes.Conta;

@Component
public class RepositorioDeAplicacoesPersistente implements RepositorioDeAplicacoes {
	
	private final Session session;

	public RepositorioDeAplicacoesPersistente(final Session session){
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aplicacao> carregaAplicacoesDaConta(final Conta conta) {
		return (List<Aplicacao>) session.createQuery("from Aplicacao as aplicacao" +
													" where aplicacao.conta = :conta")
										.setParameter("conta", conta).list();
	}

	@Override
	public void grava(final Aplicacao aplicacao) {
		session.save(aplicacao);
	}

	@Override
	public Aplicacao buscaAplicacao(final int id) {
		return (Aplicacao) session.createQuery("from Aplicacao where id = :id").setParameter("id", id).uniqueResult();
	}

	@Override
	public void exclui(final Aplicacao aplicacao) {
		session.delete(aplicacao);
	}

}
