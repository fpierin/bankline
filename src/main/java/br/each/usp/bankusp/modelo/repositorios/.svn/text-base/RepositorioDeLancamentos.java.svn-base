package br.each.usp.bankusp.modelo.repositorios;

import java.util.List;

import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

public interface RepositorioDeLancamentos {

	void grava(Lancamento lancamento);

	List<Lancamento> obterTransferenciasAgendadasDaConta(Conta contaLogada);

	Lancamento obterLancamento(int id);

	void exclui(Lancamento lancamento);

	Lancamento obterLancamentoDoCodigo(int codigo);

	List<Lancamento> obterPagamentosAgendadosDaConta(Conta contaLogada);

}
