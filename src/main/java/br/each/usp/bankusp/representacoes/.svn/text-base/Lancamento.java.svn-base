package br.each.usp.bankusp.representacoes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import br.each.usp.bankusp.constantes.TipoDeLancamento;

@Entity
public class Lancamento {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "LANCAMENTO", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@ManyToOne(targetEntity=Conta.class)
	@JoinColumn(nullable=false)
	private Conta conta;
	
	@Column
	private Double valor;
	
	@Column
	private Date data;
	
	@Column
	private String descricao;
	
	@Column
	@Enumerated(value=EnumType.STRING)
	private TipoDeLancamento tipo;

	@Column
	private int codigo;
	
	public Lancamento() {}

	public Lancamento(final int id, final Conta conta, final Double valor, final Date data, final String descricao, final TipoDeLancamento tipo, final int codigo) {
		this.id = id;
		this.conta = conta;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.tipo = tipo;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(final Conta conta) {
		this.conta = conta;
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

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean isFuturo(){
		return this.data.after(new Date());
	}

	public void setTipo(final TipoDeLancamento tipo) {
		this.tipo = tipo;
	}

	public TipoDeLancamento getTipo() {
		return tipo;
	}

	public void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
