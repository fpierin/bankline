package br.each.usp.bankusp.construtores;

import java.util.Date;
import java.util.List;

import br.each.usp.bankusp.constantes.TipoDePessoa;
import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;

public class UmCliente {
	
	private int id;
	
	private List<Conta> contas;
	
	private String endereco;
	
	private Date dataDoUltimoAcesso;
	
	private Date dataDeCadastro;
	
	private String cpf;
	
	private String rg;
	
	private String nome;

	private TipoDePessoa tipoDePessoa;

	private String cidade;

	private String estado;

	private String pais;

	public Cliente novo() {
		return new Cliente(id, nome, rg, cpf, endereco, cidade, estado, pais, dataDeCadastro, dataDoUltimoAcesso, tipoDePessoa, contas);
	}
	
	public UmCliente deId(final int id) {
		this.id = id;
		return this;
	}
	
	public UmCliente deTipo(final TipoDePessoa tipoDePessoa) {
		this.tipoDePessoa = tipoDePessoa;
		return this;
	}	
	
	public UmCliente comDataDeCadastro(final Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
		return this;
	}		
	
	public UmCliente comUltimaDataDeAcesso(final Date dataDoUltimoAcesso) {
		this.dataDoUltimoAcesso = dataDoUltimoAcesso;
		return this;
	}	
	
	public UmCliente residenteNoEndereco(final String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public UmCliente doCPF(final String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public UmCliente doRG(final String rg) {
		this.rg = rg;
		return this;
	}
	
	public UmCliente deNome(final String nome) {
		this.nome = nome;
		return this;
	}				
	
	public UmCliente donoDaContas(final List<Conta> contas) {
		this.contas = contas;
		return this;
	}
	
	

}
