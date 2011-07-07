package br.each.usp.bankusp.modelo.repositorios;

import br.each.usp.bankusp.representacoes.Administrador;
import br.each.usp.bankusp.representacoes.Taxas;

public interface RepositorioDeAdministradores {

	boolean existeAdministrador(Administrador administrador);

	void grava(Administrador administrador);

	Taxas obterTaxas();

	void save(Taxas taxa);

}
