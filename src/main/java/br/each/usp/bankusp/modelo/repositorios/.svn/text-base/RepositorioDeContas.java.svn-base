package br.each.usp.bankusp.modelo.repositorios;

import java.util.List;

import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

public interface RepositorioDeContas {

	public void grava(final Conta conta);

	public boolean existeConta(Conta conta);

	public void adiciona(Conta conta);

	public Conta carrega(Conta conta);

	public List<Lancamento> listaMovimentacaoDaConta(Conta conta);

	public Conta carregaContaComLancamentos(Conta contaLogada);

	public Conta carrega(String codigoDaAgencia, String codigoDaConta);

	public List<Conta> listarContas();

	public Conta buscaConta(int id);

	public void exclui(Conta conta);

	public Conta obterContaCDBDaConta(Conta conta);

	public void atualiza(Conta contaAlterar);

}
