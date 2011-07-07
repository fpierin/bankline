package br.each.usp.bankusp.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

@Component
public class RepositorioDeContasPersistente implements RepositorioDeContas {
	
	private final Session session;

	public RepositorioDeContasPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public void grava(final Conta conta) {
		session.save(conta);
	}

	@Override
	public boolean existeConta(final Conta conta) {
		return (carrega(conta.getCodigoDaAgencia(), conta.getCodigoDaConta()) != null);
	}

	@Override
	public void adiciona(final Conta conta) {
		session.save(conta);		
	}

	@Override
	public Conta carrega(final Conta conta) {
		return (Conta) session.createQuery("from Conta" +
										 " where codigoDaAgencia = :codigoDaAgencia" +
	    								   " and codigoDaConta = :codigoDaConta" +
	    								   " and senha = :senha")	    								   
							  .setParameter("codigoDaAgencia", conta.getCodigoDaAgencia())
							  .setParameter("codigoDaConta", conta.getCodigoDaConta())
							  .setParameter("senha", conta.getSenha())							  
							  .uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> listaMovimentacaoDaConta(final Conta conta) {
		return (List<Lancamento>) session.createQuery("from Lancamento where conta = :conta")
										 .setParameter("conta", conta)
										 .list();
		
	}

	@Override
	public Conta carregaContaComLancamentos(final Conta conta) {
		return (Conta) session.createQuery("from Conta as conta" +
										 " left join fetch conta.lancamentos as lancamento" +
										 " where conta = :conta")
							  .setParameter("conta", conta)							  
							  .uniqueResult();
	}

	@Override
	public Conta carrega(final String codigoDaAgencia, final String codigoDaConta) {
		return (Conta) session.createQuery("from Conta" +
										 " where codigoDaAgencia = :codigoDaAgencia" +
										   " and codigoDaConta = :codigoDaConta")
							  .setParameter("codigoDaAgencia", codigoDaAgencia)
							  .setParameter("codigoDaConta", codigoDaConta)						   
							  .uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Conta> listarContas() {
		return (List<Conta>) session.createQuery("from Conta as conta" +
												" inner join fetch conta.cliente as cliente").list();
	}

	@Override
	public Conta buscaConta(final int id) {
		return (Conta) session.createQuery("from Conta where id = :id")
							  .setParameter("id", id).uniqueResult();
	}

	@Override
	public void exclui(final Conta conta) {
		session.delete(conta);
	}

	@Override
	public Conta obterContaCDBDaConta(final Conta conta) {
		return (Conta) session.createQuery("from Conta where codigoDaAgencia = :agencia and codigoDaConta = :conta")
		  .setParameter("agencia", conta.getCodigoDaAgencia())
		  .setParameter("conta", conta.getCodigoDaConta() + "/100")
		  .uniqueResult();
	}

	@Override
	public void atualiza(final Conta conta) {
		session.save(conta);
	}

}
