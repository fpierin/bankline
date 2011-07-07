package br.each.usp.bankusp.construtores;

import java.util.Date;

import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

public class UmLancamento {

	private int id;
	private Conta conta;
	private Double valor;
	private Date data;
	private String descricao;
	private TipoDeLancamento tipo;
	private int codigo;

	public Lancamento novo() {
		return new Lancamento(id, conta, valor, data, descricao, tipo, codigo);
	}
	
	public UmLancamento comId(final int id){
		this.id = id;
		return this;
	}
	
	public UmLancamento descritoComo(final String descricao){
		this.descricao = descricao;
		return this;
	}	
	
	public UmLancamento naData(final Date data){
		this.data = data;
		return this;
	}	
	
	public UmLancamento deValor(final Double valor){
		this.valor = valor;
		return this;
	}	
	
	public UmLancamento naConta(final Conta conta){
		this.conta = conta;
		return this;
	}	
	

}
