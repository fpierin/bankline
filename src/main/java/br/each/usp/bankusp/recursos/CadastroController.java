package br.each.usp.bankusp.recursos;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeClientes;
import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Sessao;

@Resource
@Path("/bankline/cadastro")
public class CadastroController {
	
	private final Sessao sessao;
	private final RepositorioDeClientes repositorioDeClientes;
	private final Result result;

	public CadastroController(final Sessao sessao, final RepositorioDeClientes repositorioDeClientes, final Result result) {
		this.sessao = sessao;
		this.repositorioDeClientes = repositorioDeClientes;
		this.result = result;
	}

	@Path("/")
	public Cliente mostrar(){
		if(this.sessao.isLogada()){
			return this.sessao.getCliente();
		}
		result.redirectTo(Bankline.class).login();
		return null;
	}
	
	@Get
	@Path("/alterar")	
	public Cliente alterar(final int id){
		return repositorioDeClientes.buscaCliente(id);
	}	
	
}
