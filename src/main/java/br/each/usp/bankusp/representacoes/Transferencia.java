package br.each.usp.bankusp.representacoes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Transferencia {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "PARCELA", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;

	@Column
	private String descricao;

	@Column
	private Double valor;
	
	@Column
	private Date data;

	private String codigoDaAgencia;
	
	private String codigoDaConta;	
	
	public Transferencia() {}

	public Transferencia(final String codigoDaAgencia, final String codigoDaConta,	final String descricao, final Double valor, final Date data) {
		this.codigoDaAgencia = codigoDaAgencia;
		this.codigoDaConta = codigoDaConta;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public String getCodigoDaAgencia() {
		return codigoDaAgencia;
	}

	public void setCodigoDaAgencia(final String codigoDaAgencia) {
		this.codigoDaAgencia = codigoDaAgencia;
	}

	public String getCodigoDaConta() {
		return codigoDaConta;
	}

	public void setCodigoDaConta(final String codigoDaConta) {
		this.codigoDaConta = codigoDaConta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(final Double valor) {
		this.valor = valor;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
