package br.each.usp.bankusp.representacoes;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.each.usp.bankusp.constantes.TipoDeConta;

@Component
@SessionScoped
public class Sessao {
	
	private Conta logada;
	
	public void login(final Conta conta){
		this.logada = conta;
	}

	public String getNome() {
		return logada.getNomeDoCliente();
	}
	
	public String getAgencia() {
		return logada.getCodigoDaAgencia();
	}
	
	public String getConta() {
		return logada.getCodigoDaConta();
	}		
	
	public Conta getContaLogada(){
		return this.logada;
	}

	public boolean isLogada(){
		return logada != null;
	}

	public void logout() {
		this.logada = null;
	}
	
	public boolean isTipoCorrente(){
		return (this.logada != null) && (this.logada.getTipoDeConta().equals(TipoDeConta.Corrente));
	}

	public Cliente getCliente() {
		return this.logada.getCliente();
	}

}
