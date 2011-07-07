package br.each.usp.bankusp.representacoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import br.each.usp.bankusp.constantes.TipoDePessoa;

@Entity
public class Cliente {
	
	@Id
	@TableGenerator(name = "TabelaGeradoraDeIds", table = "SEQUENCE",
					pkColumnName = "TABELA", valueColumnName = "NEXT_ID",
					pkColumnValue = "CLIENTE", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TabelaGeradoraDeIds")
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String rg;
	
	@Column
	private String cpf;
	
	@Column
	private String endereco;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String pais;	
	
	@Column
	private Date dataDeCadastro;
	
	@Column
	private Date dataDoUltimoAcesso;
	
	@Column
	@Enumerated(value=EnumType.STRING)	
	private TipoDePessoa tipoDePessoa;
	
	@OneToMany(targetEntity = Conta.class, mappedBy = "cliente", cascade=CascadeType.ALL)
	private List<Conta> contas = new ArrayList<Conta>();	
	
	public Cliente(final int id, final String nome, final String rg, final String cpf, final String endereco,
			final String cidade, final String estado, final String pais, final Date dataDeCadastro,
			final Date dataDoUltimoAcesso, final TipoDePessoa tipoDePessoa,
			final List<Conta> contas) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.dataDeCadastro = dataDeCadastro;
		this.dataDoUltimoAcesso = dataDoUltimoAcesso;
		this.tipoDePessoa = tipoDePessoa;
		this.contas = contas;
	}

	public Cliente() {}
	
	public String getRg() {
		return rg;
	}

	public void setRg(final String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(final Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDoUltimoAcesso() {
		return dataDoUltimoAcesso;
	}

	public void setDataDoUltimoAcesso(final Date dataDoUltimoAcesso) {
		this.dataDoUltimoAcesso = dataDoUltimoAcesso;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setContas(final List<Conta> contas) {
		this.contas = contas;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setTipoDePessoa(final TipoDePessoa tipoDePessoa) {
		this.tipoDePessoa = tipoDePessoa;
	}

	public TipoDePessoa getTipoDePessoa() {
		return tipoDePessoa;
	}
	
	public boolean isPessoaJuridica(){
		return (this.tipoDePessoa != null && tipoDePessoa.equals(TipoDePessoa.Juridica));
	}

	public void setPais(final String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

}
