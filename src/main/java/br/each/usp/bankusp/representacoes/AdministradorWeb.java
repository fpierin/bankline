package br.each.usp.bankusp.representacoes;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class AdministradorWeb {

	private Administrador logado;
	
	public void login(final Administrador administrador){
		this.logado = administrador;
	}
	
	public String getNome() {
		return logado.getNome();
	}
	
	public boolean isLogado(){
		return logado != null;
	}
}
