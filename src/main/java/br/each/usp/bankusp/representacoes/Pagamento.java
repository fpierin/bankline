package br.each.usp.bankusp.representacoes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Pagamento {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
			pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
			pkColumnValue = "PAGAMENTO", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@Column
	private String codigoDeBarras;

	@Column	
	private String descricao;
	
	@Column	
	private Date data;
	
	@Column	
	private Double valor;
	
	public Pagamento(){}

	public Pagamento(final int id, final String codigoDeBarras, final String descricao, final Date data, final Double valor) {
		this.id = id;
		this.codigoDeBarras = codigoDeBarras;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(final String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(final Double valor) {
		this.valor = valor;
	}
	
}
