package br.each.usp.bankusp.representacoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Taxas {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "TAXAS", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;

	@Column
	private Double manutencaoDeConta;
	
	@Column	
	private Double jurosPoupanca;

	@Column	
	private Double jurosPenalidadeCDB;
	
	@Column
	private Double jurosCDB;
	
	public Taxas() {}

	public Taxas(final int id, final Double manutencaoDeConta, final Double jurosPoupanca, final Double jurosPenalidadeCDB, final Double jurosCDB) {
		this.id = id;
		this.manutencaoDeConta = manutencaoDeConta;
		this.jurosPoupanca = jurosPoupanca;
		this.jurosPenalidadeCDB = jurosPenalidadeCDB;
		this.jurosCDB = jurosCDB;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Double getManutencaoDeConta() {
		return manutencaoDeConta;
	}

	public void setManutencaoDeConta(final Double manutencaoDeConta) {
		this.manutencaoDeConta = manutencaoDeConta;
	}

	public Double getJurosPoupanca() {
		return jurosPoupanca;
	}

	public void setJurosPoupanca(final Double jurosPoupanca) {
		this.jurosPoupanca = jurosPoupanca;
	}

	public Double getJurosPenalidadeCDB() {
		return jurosPenalidadeCDB;
	}

	public void setJurosPenalidadeCDB(final Double jurosPenalidadeCDB) {
		this.jurosPenalidadeCDB = jurosPenalidadeCDB;
	}

	public Double getJurosCDB() {
		return jurosCDB;
	}

	public void setJurosCDB(final Double jurosCDB) {
		this.jurosCDB = jurosCDB;
	}
	
}
