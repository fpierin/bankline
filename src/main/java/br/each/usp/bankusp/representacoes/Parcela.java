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
public class Parcela {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "CONTA", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@Column
	private Double valor;
	
	@Column
	private int numero;
	
	@Column
	private boolean quitada;
	
	@Column
	private Date data;	
	
	@ManyToOne(targetEntity=Emprestimo.class)
	@JoinColumn(nullable=false)
	private Emprestimo emprestimo;
	
	public Parcela() {}

	public Parcela(final int id, final Double valor, final int numero, final boolean quitada, final Emprestimo emprestimo, final Date data) {
		this.id = id;
		this.valor = valor;
		this.numero = numero;
		this.quitada = quitada;
		this.emprestimo = emprestimo;
		this.data = data;
	}

	public void setEmprestimo(final Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setValor(final Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setQuitada(final boolean quitada) {
		this.quitada = quitada;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public void quitar() {
		this.quitada = true;
	}		

}
