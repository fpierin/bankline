package br.each.usp.bankusp.representacoes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Rendimento {

	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "RENDIMENTO", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@Column
	private Double valor;
	
	@Column
	private Date data;
	
	@ManyToOne(targetEntity=Aplicacao.class)
	@JoinColumn(nullable=false)
	private Aplicacao aplicacao;	

	public Rendimento() {	}

	public Rendimento(final int id, final Double valor, final Date data, final Aplicacao aplicacao) {
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.aplicacao = aplicacao;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(final Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}
	
}
