package br.each.usp.bankusp.modelo.repositorios;

import java.util.List;

import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Emprestimo;

public interface RepositorioDeEmprestimos {

	void grava(Emprestimo emprestimo);

	List<Emprestimo> carregaEmprestimosDaConta(Conta conta);

}
