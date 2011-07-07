package br.each.usp.bankusp.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

@Component
public class RepositorioDeLancamentosPersistente implements	RepositorioDeLancamentos {

	private final Session session;
	
	public RepositorioDeLancamentosPersistente(final Session session) {
		this.session = session;
	}

	@Override
	public void grava(final Lancamento lancamento) {
		this.session.save(lancamento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> obterTransferenciasAgendadasDaConta(final Conta conta) {
		return (List<Lancamento>) session.createQuery("from Lancamento" +
													" where conta = :conta" +
													  " and tipo = :tipo " +
													  " and valor < 0")
										 .setParameter("conta", conta)
										 .setParameter("tipo", TipoDeLancamento.Transferencia)										 
										.list();
	}

	@Override
	public Lancamento obterLancamento(final int id) {
		return (Lancamento) session.createQuery("from Lancamento where id =:id").setParameter("id", id).uniqueResult();
	}

	@Override
	public void exclui(final Lancamento lancamento) {
		session.delete(lancamento);
	}

	@Override
	public Lancamento obterLancamentoDoCodigo(final int codigo) {
		return (Lancamento) session.createQuery("from Lancamento where codigo = :codigo").setParameter("codigo", codigo).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> obterPagamentosAgendadosDaConta(final Conta conta) {
		return (List<Lancamento>) session.createQuery("from Lancamento" +
													" where conta = :conta" +
													  " and tipo = :tipo " +
													  " and valor < 0")
										 .setParameter("conta", conta)
										 .setParameter("tipo", TipoDeLancamento.Pagamento)										 
										.list();
	}

}
