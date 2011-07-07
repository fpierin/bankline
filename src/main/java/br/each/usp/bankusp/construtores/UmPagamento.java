package br.each.usp.bankusp.construtores;

import java.util.Date;

import br.each.usp.bankusp.representacoes.Pagamento;

public class UmPagamento {

	private double valor;
	private Date data;
	private String descricao;
	private String codigoDeBarras;
	private int id;

	public Pagamento novo() {
		return new Pagamento(id, codigoDeBarras, descricao, data, valor);
	}
	
	public UmPagamento comId(final int id){
		this.id = id;
		return this;
	}	
	
	public UmPagamento doCodigoDeBarras(final String codigoDeBarras){
		this.codigoDeBarras = codigoDeBarras;
		return this;
	}	
	
	public UmPagamento descritoComo(final String descricao){
		this.descricao = descricao;
		return this;
	}	
	
	public UmPagamento naData(final Date data){
		this.data = data;
		return this;
	}	
	
	public UmPagamento deValor(final double valor){
		this.valor = valor;
		return this;
	}
}
