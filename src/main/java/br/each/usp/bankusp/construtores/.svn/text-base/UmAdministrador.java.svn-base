package br.each.usp.bankusp.construtores;

import br.each.usp.bankusp.representacoes.Administrador;

public class UmAdministrador {

	private int id;
	private String login;
	private String senha;
	private String nome;

	public Administrador novo() {
		return new Administrador(id, login, senha, nome);
	}
	
	public UmAdministrador conhecidoComo(final String nome){
		this.nome = nome;
		return this;
	}	
	
	public UmAdministrador comSenha(final String senha){
		this.senha = senha;
		return this;
	}	

	public UmAdministrador doLogin(final String login){
		this.login = login;
		return this;
	}	
	
	public UmAdministrador comId(final int id){
		this.id = id;
		return this;
	}

}
