package br.each.usp.bankusp.representacoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Aplicacao {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "APLICACAO", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@ManyToOne(targetEntity=Conta.class)
	@JoinColumn(nullable=false)
	private Conta conta;
	
	@Column
	private Date dataDeVencimento;
	
	@Column
	private Date dataDeAplicacao;	
	
	@Column
	private Double valorInicial;
	
	@Column
	private Double valorAtual;	
	
	@OneToMany(targetEntity = Rendimento.class, mappedBy = "aplicacao", cascade=CascadeType.ALL)		
	private List<Rendimento> rendimentos = new ArrayList<Rendimento>();		
	
	public Aplicacao() { }
	
	public Aplicacao(final int id, final Conta conta, final Date dataDeVencimento, final Date dataDeAplicacao, final Double valorInicial, final List<Rendimento> rendimentos, final Double valorAtual) {
		this.id = id;
		this.conta = conta;
		this.dataDeVencimento = dataDeVencimento;
		this.dataDeAplicacao = dataDeAplicacao;
		this.valorInicial = valorInicial;
		this.rendimentos = rendimentos;
		this.valorAtual = valorAtual;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setConta(final Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setDataDeVencimento(final Date data) {
		this.dataDeVencimento = data;
	}

	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setValorInicial(final Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setRendimentos(final List<Rendimento> rendimentos) {
		this.rendimentos = rendimentos;
	}

	public List<Rendimento> getRendimentos() {
		return rendimentos;
	}	
	
	public Double totalDeRendimentos(){
		Double total = 0.0;
		if(this.rendimentos != null){
			for(final Rendimento rendimento: rendimentos){
				total += rendimento.getValor();
			}
		}
		return total;
	}

	public void setValorAtual(final Double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Double getValorAtual() {
		return valorAtual;
	}
	
	public boolean isResgatavel(){
		return (dataDeVencimento.compareTo(new Date()) < 0);
	}

	public void setDataDeAplicacao(Date dataDeAplicacao) {
		this.dataDeAplicacao = dataDeAplicacao;
	}

	public Date getDataDeAplicacao() {
		return dataDeAplicacao;
	}

}
