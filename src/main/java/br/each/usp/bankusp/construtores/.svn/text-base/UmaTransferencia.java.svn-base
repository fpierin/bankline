package br.each.usp.bankusp.construtores;

import java.util.Date;

import br.each.usp.bankusp.representacoes.Transferencia;

public class UmaTransferencia {

	private String codigoDaAgencia;
	private String codigoDaConta;
	private String descricao;
	private Double valor;
	private Date data;

	public Transferencia nova() {
		return new Transferencia(codigoDaAgencia, codigoDaConta, descricao, valor, data);
	}
	
	public UmaTransferencia paraConta(final String codigoDaConta){
		this.codigoDaConta = codigoDaConta;
		return this;
	}
	
	public UmaTransferencia naData(final Date data){
		this.data = data;
		return this;
	}	
	
	public UmaTransferencia daAgencia(final String codigoDaAgencia){
		this.codigoDaAgencia = codigoDaAgencia;
		return this;
	}
	
	public UmaTransferencia descritaComo(final String descricao){
		this.descricao = descricao;
		return this;
	}
	
	public UmaTransferencia de(final double valor){
		this.valor = valor;
		return this;
	}			

}
