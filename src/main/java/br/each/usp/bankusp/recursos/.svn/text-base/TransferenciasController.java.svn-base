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
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Sessao;
import br.each.usp.bankusp.representacoes.Transferencia;

@Resource
@Path("/bankline/transferencias")
public class TransferenciasController {
	
	private final Result result;
	private final RepositorioDeContas repositorioDeContas;
	private final Sessao sessao;
	private final Validator validator;
	private final RepositorioDeLancamentos repositorioDeLancamentos;

	public TransferenciasController(final Result result, final RepositorioDeContas repositorioDeContas, 
			final RepositorioDeLancamentos repositorioDeLancamentos, 
			final Sessao sessao, final Validator validator) {
		this.result = result;
		this.repositorioDeContas = repositorioDeContas;
		this.repositorioDeLancamentos = repositorioDeLancamentos;
		this.sessao = sessao;
		this.validator = validator;
	}

	@Path("/")
	public void index(){}
	
	public void realizar(){}
	
	public void agendar(){}	
	
	public List<Lancamento> listar(){
		return repositorioDeLancamentos.obterTransferenciasAgendadasDaConta(sessao.getContaLogada());
	}	
	
	public void cancelar(final int id){
		final Lancamento lancamento = repositorioDeLancamentos.obterLancamento(id);
		final int codigo = lancamento.getCodigo();
		repositorioDeLancamentos.exclui(lancamento);
		final Lancamento lancamentoPeloCodigo = repositorioDeLancamentos.obterLancamentoDoCodigo(codigo);
		if (lancamentoPeloCodigo != null){
			repositorioDeLancamentos.exclui(lancamentoPeloCodigo);		
		}
		result.redirectTo(TransferenciasController.class).listar();	
	}
	
	@Post
	public void realizarTransferencia(final Transferencia transferencia){
		if (sessao.isLogada()){
			final Conta contaDebitada = this.sessao.getContaLogada();
			final String codigoDaAgencia = transferencia.getCodigoDaAgencia();
			final String codigoDaConta = transferencia.getCodigoDaConta();
			final Date dataDeRealizacao = new Date();
			final int codigo = dataDeRealizacao.hashCode();
			
			if (transferencia.getData() == null){
				transferencia.setData(dataDeRealizacao);
			}
			
			if (transferencia.getData().before(dataDeRealizacao)){
				validator.add(new ValidationMessage("Uma transferência não pode ser agendada para o passado", "transferencia.data"));				
			} else {
				if(codigoDaAgencia.equalsIgnoreCase(contaDebitada.getCodigoDaAgencia()) || codigoDaConta.equalsIgnoreCase(contaDebitada.getCodigoDaConta()) ){
					validator.add(new ValidationMessage("Uma transferência não pode ser realizada para a própria conta", "transferencia.codigoDaConta"));
				} else {
					final Conta contaCreditada = repositorioDeContas.carrega(codigoDaAgencia, codigoDaConta);
					if (contaCreditada == null){
						validator.add(new ValidationMessage("Conta inexistente", "transferencia.codigoDaConta"));			
					} else {
						repositorioDeLancamentos.grava(new Lancamento(0, contaDebitada, -transferencia.getValor(), transferencia.getData(), 
								transferencia.getDescricao(), TipoDeLancamento.Transferencia, codigo));
						repositorioDeLancamentos.grava(new Lancamento(0, contaCreditada, transferencia.getValor(), transferencia.getData(), 
								transferencia.getDescricao(), TipoDeLancamento.Transferencia, codigo));
						result.redirectTo(ContasController.class).extrato();					
					}		
				}	
			}
			
			validator.onErrorUsePageOf(TransferenciasController.class).index();			
		} else {
			result.redirectTo(Bankline.class).login();
		}
	}	

}
