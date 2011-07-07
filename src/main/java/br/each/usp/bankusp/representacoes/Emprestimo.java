package br.each.usp.bankusp.representacoes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import br.each.usp.bankusp.constantes.Modalidade;

@Entity
public class Emprestimo {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "EMPRESTIMO", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")	
	private int id;
	
	@Column
	private Double valor;
	
	@Column
	@Enumerated(value=EnumType.STRING)
	private Modalidade modalidade;
	
	@ManyToOne(targetEntity=Conta.class)
	@JoinColumn(nullable=false)
	private Conta conta;	
	
	@Column	
	private String descricao;
	
	@OneToMany(targetEntity = Parcela.class, mappedBy = "emprestimo", cascade=CascadeType.ALL)		
	private List<Parcela> parcelas = new ArrayList<Parcela>();	

	public Emprestimo() {}
	
	public Emprestimo(final int id, final Double valor, final Modalidade modalidade, final String descricao, final Conta conta, final List<Parcela> parcelas) {
		this.id = id;
		this.valor = valor;
		this.modalidade = modalidade;
		this.descricao = descricao;
		this.conta = conta;
		this.parcelas = parcelas;
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

	public void setModalidade(final Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setConta(final Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setParcelas(final List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public boolean isQuitado() {
		if (parcelas != null) {
			for(final Parcela parcela: parcelas){
				if(!parcela.isQuitada()){
					return false;
				}
			}
		}
		return true;
	}
	
}
