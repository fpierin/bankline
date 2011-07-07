package br.each.usp.bankusp.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeEmprestimos;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Emprestimo;

@Component
public class RepositorioDeEmprestimosPersistente implements RepositorioDeEmprestimos {

	private final Session session;

	public RepositorioDeEmprestimosPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public void grava(final Emprestimo emprestimo) {
		session.save(emprestimo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Emprestimo> carregaEmprestimosDaConta(final Conta conta) {
		return (List<Emprestimo>) session.createQuery("from Emprestimo " +
													" where conta = :conta")
										 .setParameter("conta", conta).list();
	}
	
	
}
