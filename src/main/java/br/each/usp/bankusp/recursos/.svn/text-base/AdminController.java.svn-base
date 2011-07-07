package br.each.usp.bankusp.recursos;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.autorizacao.Restrito;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAdministradores;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeClientes;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.representacoes.Administrador;
import br.each.usp.bankusp.representacoes.AdministradorWeb;
import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Taxas;

@Resource
@Path("/admin")
public class AdminController {
	
	private final AdministradorWeb administradorWeb;
	private final RepositorioDeContas repositorioDeContas;
	private final RepositorioDeClientes repositorioDeClientes;
	private final RepositorioDeAdministradores repositorioDeAdministradores;
	private final Validator validator;
	private final Result result;

	public AdminController(final AdministradorWeb administradorWeb,
			final Result result,
			final RepositorioDeAdministradores repositorioDeAdministradores, 
			final RepositorioDeClientes repositorioDeClientes, 
			final RepositorioDeContas repositorioDeContas,
			final Validator validator) {
		this.administradorWeb = administradorWeb;
		this.result = result;
		this.repositorioDeAdministradores = repositorioDeAdministradores;
		this.repositorioDeClientes = repositorioDeClientes;
		this.repositorioDeContas = repositorioDeContas;
		this.validator = validator;
	}
	
	@Path("/")
	@Restrito
	public void servicos() {}	

	@Restrito
	public Cliente novaConta(final int id){
		return repositorioDeClientes.buscaCliente(id);
	}
	
	@Post
	@Restrito
	public void adicionarConta(final Conta conta){
		conta.reabre();
		repositorioDeContas.adiciona(conta);
		result.redirectTo(AdminController.class).listarContas();
	}
	
	@Restrito
	public Cliente abrirConta(final int id){
		return repositorioDeClientes.buscaCliente(id);
	}
	
	@Restrito
	public Taxas gerenciarTaxas(){
		Taxas taxa = null;
		try{
			taxa = repositorioDeAdministradores.obterTaxas();	
		}catch(final Exception e){
			if (taxa == null){
				taxa = new Taxas(1, 10.0, 0.5, 0.1, 0.6);
				repositorioDeAdministradores.save(taxa);
			}
		}
		return taxa;
	}	
	
	@Restrito
	@Path("/taxas/altera")
	public void editaTaxa(final Taxas taxas){
		validator.onErrorUsePageOf(AdminController.class).gerenciarTaxas();		
		repositorioDeAdministradores.save(taxas);
		result.redirectTo(AdminController.class).servicos();		
	}		
	
	@Restrito
	public void excluirCliente(final int id){
		final Cliente cliente = repositorioDeClientes.buscaCliente(id);
		if(cliente != null){
			repositorioDeClientes.excluirCliente(cliente);
		}
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		result.redirectTo(AdminController.class).listarClientes();		
	}
	
	@Restrito
	public Cliente editarCliente(final int id){
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		final Cliente cliente = repositorioDeClientes.buscaCliente(id);
		return cliente; 
	}
	
	@Restrito
	public Conta editarConta(final int id){
		validator.onErrorUsePageOf(AdminController.class).listarContas();
		final Conta conta= repositorioDeContas.buscaConta(id);
		return conta; 
	}
	
	@Post	
	@Restrito
	public void editaConta(final Conta conta){
		validator.onErrorUsePageOf(AdminController.class).editarConta(conta.getId());
		final Conta contaAlterar = repositorioDeContas.buscaConta(conta.getId());
		contaAlterar.setLimite(conta.getLimite());
		contaAlterar.setSenha(conta.getSenha());
		repositorioDeContas.atualiza(contaAlterar);
		result.redirectTo(AdminController.class).listarContas();
	}		
	
	@Post	
	@Restrito
	public void editaCliente(final Cliente cliente){
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		cliente.setDataDeCadastro(new Date());
		cliente.setDataDoUltimoAcesso(new Date());		
		repositorioDeClientes.atualiza(cliente);
		result.redirectTo(AdminController.class).listarClientes();
	}	
	
	@Restrito
	public void encerrarConta(final int id){
		final Conta conta = repositorioDeContas.buscaConta(id);
		if(conta != null){
			conta.encerra();
			repositorioDeContas.grava(conta);
		}
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		result.redirectTo(AdminController.class).listarContas();		
	}
	
	@Restrito
	public void reabrirConta(final int id){
		final Conta conta = repositorioDeContas.buscaConta(id);
		if(conta != null){
			conta.reabre();
			repositorioDeContas.grava(conta);
		}
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		result.redirectTo(AdminController.class).listarContas();		
	}			
	
	@Restrito
	public void excluirConta(final int id){
		final Conta conta = repositorioDeContas.buscaConta(id);
		repositorioDeContas.exclui(conta);
		validator.onErrorUsePageOf(AdminController.class).listarClientes();
		result.redirectTo(AdminController.class).listarContas();		
	}		
	
	@Restrito
	public void cadastrarCliente(){}
	
	@Restrito
	@Path("/listarContas")	
	public List<Conta> listarContas(){
		return repositorioDeContas.listarContas();
	}
	
	@Restrito
	@Path("/listarClientes")	
	public List<Cliente> listarClientes(){
		return repositorioDeClientes.listarClientes();		
	}			
	
	@Restrito
	@Post
	public void novoCliente(final Cliente cliente){
		cliente.setDataDeCadastro(new Date());
		cliente.setDataDoUltimoAcesso(new Date());		
		repositorioDeClientes.grava(cliente);
		result.redirectTo(AdminController.class).listarClientes();		
	}

	public void adicionaAdministrador(final Administrador administrador){
		if(repositorioDeAdministradores.existeAdministrador(administrador)){
			validator.add(new ValidationMessage("Login já existe", "usuario.login"));
		}
		repositorioDeAdministradores.grava(administrador);
		result.redirectTo(AdminController.class).servicos();
	}
	
	public void novo(){}	
	
	public void login() {}
	
	@Post
	@Path("/login")
	public void login(final Administrador administrador){
		if(repositorioDeAdministradores.existeAdministrador(administrador)){
			result.redirectTo(AdminController.class).servicos();
			administradorWeb.login(administrador);
		} else {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
			validator.onErrorUsePageOf(AdminController.class).login();
			result.redirectTo(AdminController.class).login();
		}
	}	

}
