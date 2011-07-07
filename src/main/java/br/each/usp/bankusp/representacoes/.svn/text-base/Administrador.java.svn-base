package br.each.usp.bankusp.representacoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Administrador {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "ADMINISTRADOR", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")
	private int id;
	
	@Column
	public String login;

	@Column
	public String senha;
	
	@Column
	public String nome;
	
	public Administrador() {}
	
	public Administrador(final int id, final String login, final String senha, final String nome) {
		super();
		this.id = id;
 		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
