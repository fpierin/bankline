package br.each.usp.bankusp.construtores;

import java.util.Date;
import java.util.List;

import br.each.usp.bankusp.constantes.TipoDeConta;
import br.each.usp.bankusp.representacoes.Aplicacao;
import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Emprestimo;
import br.each.usp.bankusp.representacoes.Lancamento;

public class UmaConta {

	private int id;
	private String codigoDaAgencia;
	private String codigoDaConta;
	private String senha;
	private Cliente cliente;
	private List<Lancamento> lancamentos;
	private Date dataDeEncerramento;
	private Date dataDeCriacao;
	private boolean ativa;
	private TipoDeConta tipoDeConta;
	private List<Emprestimo> emprestimos;
	private List<Aplicacao> aplicacoes;
	private Double limite;

	public Conta nova() {
		return new Conta(id, codigoDaAgencia, codigoDaConta, senha, cliente, lancamentos, dataDeEncerramento, dataDeCriacao, ativa, tipoDeConta, emprestimos, aplicacoes, limite);
	}
	
	public UmaConta comId(final int id){
		this.id = id;
		return this;
	}
	
	public UmaConta doTipo(final TipoDeConta tipoDeConta){
		this.tipoDeConta = tipoDeConta;
		return this;
	}		
	
	public UmaConta daAgenciaDeCodigo(final String codigoDaAgencia){
		this.codigoDaAgencia = codigoDaAgencia;
		return this;
	}	
	
	public UmaConta daContaDeCodigo(final String codigoDaConta){
		this.codigoDaConta = codigoDaConta;
		return this;
	}
	
	public UmaConta protegidaPelaSenha(final String senha){
		this.senha = senha;
		return this;
	}
	
	public UmaConta doCliente(final Cliente cliente){
		this.cliente = cliente;
		return this;
	}		
	
	public UmaConta dosLancamentos(final List<Lancamento> lancamentos){
		this.lancamentos = lancamentos;
		return this;
	}			
	
	

}
