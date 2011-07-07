package br.each.usp.bankusp.representacoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import br.each.usp.bankusp.constantes.TipoDeConta;

@Entity
public class Conta {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "PARCELA", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@Column
	private String codigoDaAgencia;
	
	@Column
	private String codigoDaConta;
	
	@Column
	private String senha;
	
	@Column
	@Enumerated(value=EnumType.STRING)
	private TipoDeConta tipoDeConta;	
	
	@Column
	private Date dataDeEncerramento;

	@Column	
	private Date dataDeCriacao;

	@Column		
	private boolean ativa;
	
	@Column		
	private Double limite;	
	
	@ManyToOne(targetEntity=Cliente.class)
	@JoinColumn(nullable=false)	
	private Cliente cliente;
	
	@OneToMany(targetEntity = Lancamento.class, mappedBy = "conta")		
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	@OneToMany(targetEntity = Emprestimo.class, mappedBy = "conta", fetch=FetchType.EAGER)		
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	@OneToMany(targetEntity = Aplicacao.class, mappedBy = "conta")	
	private List<Aplicacao> aplicacoes = new ArrayList<Aplicacao>();	
	
	public Conta() {}	
	
	public Conta(final int id, final String codigoDaAgencia, final String codigoDaConta, final String senha, final Cliente cliente, final List<Lancamento> lancamentos, 
			final Date dataDeEncerramento, final Date dataDeCriacao, final boolean ativa, final TipoDeConta tipoDeConta, final List<Emprestimo> emprestimos,
			final List<Aplicacao> aplicacoes, final Double limite) {
		this.id = id;
		this.codigoDaAgencia = codigoDaAgencia;
		this.codigoDaConta = codigoDaConta;
		this.senha = senha;
		this.cliente = cliente;
		this.lancamentos = lancamentos;
		this.dataDeEncerramento = dataDeEncerramento;
		this.dataDeCriacao = dataDeCriacao;
		this.ativa = ativa;
		this.tipoDeConta = tipoDeConta;
		this.emprestimos = emprestimos;
		this.aplicacoes = aplicacoes;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getNomeDoCliente() {
		return this.cliente.getNome();
	}

	public double getSaldoAtual(){
		Double resultadoDaSoma = 0.0;
		if(lancamentos != null){
			for(final Lancamento lancamento: lancamentos){
				if (lancamento.getData().before(new Date())){
					resultadoDaSoma += lancamento.getValor();
				}
			}
		}
		return resultadoDaSoma;
	}

	public double getSaldoFuturo(){
		Double resultadoDaSoma = 0.0;
		if(lancamentos != null){		
			for(final Lancamento lancamento: lancamentos){
				if (lancamento.getData().after(new Date())){
					resultadoDaSoma += lancamento.getValor();
				}
			}
		}
		return resultadoDaSoma;
	}	
	
	public double getSaldoTotal(){
		Double resultadoDaSoma = 0.0;
		if(lancamentos != null){
			for(final Lancamento lancamento: lancamentos){
				resultadoDaSoma += lancamento.getValor();
			}
		}
		return resultadoDaSoma;
	}

	public void setLancamentos(final List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public int getTotalDeLancamentos(){
		return this.lancamentos != null ? this.lancamentos.size() : 0;
	}

	public void encerra() {
		this.setDataDeEncerramento(new Date());
		this.ativa = false;
	}

	public void setDataDeCriacao(final Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeEncerramento(final Date dataDeEncerramento) {
		this.dataDeEncerramento = dataDeEncerramento;
	}

	public Date getDataDeEncerramento() {
		return dataDeEncerramento;
	}

	public void setAtiva(final boolean ativa) {
		this.ativa = ativa;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setTipoDeConta(final TipoDeConta tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public TipoDeConta getTipoDeConta() {
		return tipoDeConta;
	}

	public void reabre() {
		if (this.dataDeCriacao == null){
			this.dataDeCriacao = new Date();
		}
		this.setDataDeEncerramento(null);
		this.ativa = true;		
	}

	public boolean isPoupanca() {
		return (tipoDeConta != null && tipoDeConta.equals(TipoDeConta.Poupanca));
	}

	public void setEmprestimos(final List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public boolean isPossuiEmprestimos() {
		if (this.emprestimos != null){
			for(final Emprestimo emprestimo: emprestimos){
				if (!emprestimo.isQuitado()){
					return true;
				}
			}
		}
		return false;
	}

	public void copia(final Conta conta) {
		conta.setAtiva(this.ativa);
		conta.setCliente(this.cliente);
		conta.setCodigoDaAgencia(this.codigoDaAgencia);
		conta.setCodigoDaConta(this.codigoDaConta);
		conta.setDataDeCriacao(this.dataDeCriacao);
		conta.setSenha(this.senha);
		conta.setTipoDeConta(this.tipoDeConta);		
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getLimite() {
		return limite;
	}

}
