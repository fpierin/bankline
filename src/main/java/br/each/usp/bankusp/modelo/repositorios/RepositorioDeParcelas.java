package br.each.usp.bankusp.modelo.repositorios;

import br.each.usp.bankusp.representacoes.Parcela;

public interface RepositorioDeParcelas {

	Parcela obterParcela(int id);

	void atualiza(Parcela parcela);

}
