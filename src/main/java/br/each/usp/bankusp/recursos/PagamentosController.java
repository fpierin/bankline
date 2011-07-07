package br.each.usp.bankusp.recursos;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDePagamentos;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Pagamento;
import br.each.usp.bankusp.representacoes.Sessao;

@Resource
@Path("/bankline/pagamentos")
public class PagamentosController {
	
	private final RepositorioDePagamentos repositorioDePagamentos;
	private final Sessao sessao;
	private final RepositorioDeLancamentos repositorioDeLancamentos;
	private final Result result;
	private final Validator validator;

	public PagamentosController(final RepositorioDeLancamentos repositorioDeLancamentos, final RepositorioDePagamentos repositorioDePagamentos, 
			final Result result, final Sessao sessao, final Validator validator) {
		this.repositorioDeLancamentos = repositorioDeLancamentos;
		this.repositorioDePagamentos = repositorioDePagamentos;
		this.result = result;
		this.sessao = sessao;
		this.validator = validator;
	}

	@Path("/")
	public void index(){}
	
	public void realizar(){}
	
	public void agendar(){}	
	
	public void cancelar(final int id){
		final Lancamento lancamento = repositorioDeLancamentos.obterLancamento(id);
		repositorioDeLancamentos.exclui(lancamento);
		result.redirectTo(PagamentosController.class).listar();	
	}	
	
	public List<Lancamento> listar(){
		return repositorioDeLancamentos.obterPagamentosAgendadosDaConta(sessao.getContaLogada());
	}	
	
	public void cancelarTransferencia(final int id){}
	
	@Post
	@Path("/novo")	
	public void novo(final Pagamento pagamento){
		validator.onErrorUsePageOf(PagamentosController.class).index();		
		final Date dataAtual = new Date();
		if (pagamento.getData() == null) {
			pagamento.setData(dataAtual);
		}
		
		final Date data = pagamento.getData();
		if (!data.before(new Date())){
			repositorioDePagamentos.grava(pagamento);
			final Double valorNegativo = -pagamento.getValor();
			final Conta contaLogada = sessao.getContaLogada();
			final int codigoDoLancamento = new Date().hashCode();
			final Lancamento lancamento = new Lancamento(0, contaLogada, valorNegativo, pagamento.getData(), pagamento.getDescricao(), TipoDeLancamento.Pagamento, codigoDoLancamento);
			repositorioDeLancamentos.grava(lancamento);
			result.redirectTo(ContasController.class).extrato();			
		} else {
			validator.add(new ValidationMessage("Um pagamento não pode ser lançado com data retroativa", "pagamento.data"));
			validator.onErrorForwardTo(PagamentosController.class).agendar();			
		}

		
	}

}
