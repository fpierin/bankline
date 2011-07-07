package br.each.usp.bankusp.recursos;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Sessao;

@Resource
@Path("/")
public class Bankline {
	
	private final Validator validator;
	private final Result result;
	private final RepositorioDeContas repositorioDeContas;
	private final Sessao sessao;

	public Bankline(final Result result, final Validator validator, final RepositorioDeContas repositorioDeContas, final Sessao sessao) {
		this.result = result;
		this.validator = validator;
		this.repositorioDeContas = repositorioDeContas;
		this.sessao = sessao;	
	}
	
	@Path("/")
	public void index(){
		if (sessao.isLogada()){
			result.redirectTo(ContasController.class).extrato();			
		} else {
			result.redirectTo(Bankline.class).login();			
		}
	}
	
	@Get
	@Path("/bankline/login")
	public void login(){}
	
	@Post
	@Path("/bankline/login")
	public void login(final Conta conta){
		final Conta carregada = repositorioDeContas.carrega(conta);
		if (carregada == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		validator.onErrorUsePageOf(Bankline.class).login();
		sessao.login(carregada);
		result.redirectTo(ContasController.class).extrato();
	}
	
	@Path("/bankline/logout")
	public void logout() {
		sessao.logout();
		result.redirectTo(Bankline.class).login();
	}	

}
