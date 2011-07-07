package br.each.usp.bankusp.recursos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAdministradores;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAplicacoes;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.representacoes.Aplicacao;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Sessao;
import br.each.usp.bankusp.representacoes.Taxas;
import br.each.usp.bankusp.representacoes.Transferencia;

@Resource
@Path("/bankline/aplicacoes")
public class AplicacoesController {

	private final Validator validator;
	private final RepositorioDeContas repositorioDeContas;
	private final Sessao sessao;
	private final RepositorioDeLancamentos repositorioDeLancamentos;
	private final RepositorioDeAplicacoes repositorioDeAplicacoes;
	private final Result result;
	private final RepositorioDeAdministradores repositorioDeAdministradores;

	public AplicacoesController(final Sessao sessao, 
			final RepositorioDeContas repositorioDeContas, 
			final Validator validator, 
			final RepositorioDeLancamentos repositorioDeLancamentos,
			final RepositorioDeAplicacoes repositorioDeAplicacoes,
			final RepositorioDeAdministradores repositorioDeAdministradores,
			final Result result) {
		this.sessao = sessao;
		this.repositorioDeContas = repositorioDeContas;
		this.validator = validator;
		this.repositorioDeLancamentos = repositorioDeLancamentos;
		this.repositorioDeAplicacoes = repositorioDeAplicacoes;
		this.repositorioDeAdministradores = repositorioDeAdministradores;
		this.result = result;
	}

	@Path("/")	
	public void aplicacoes(){}
	
	@Path("/cdb")	
	public void cdb(){}
	
	@Path("/cdb/investir")	
	public void investir(){}
	
	@Post
	@Path("/cdb/aplicar")	
	public void realizarCDB(final Aplicacao aplicacao){			
		if (sessao.isLogada()){
			final Date dataVencimento = aplicacao.getDataDeVencimento();
			final Calendar calendar = new GregorianCalendar();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, 3);
			final Date dataMinima = new Date(calendar.getTime().getTime()); 
			if (dataVencimento.before(dataMinima)){
				validator.add(new ValidationMessage("O prazo para aplicação em CDB é de no minimo 3 meses", "aplicacao.data"));
			} else {
				
				final Conta conta = sessao.getContaLogada();
				aplicacao.setDataDeAplicacao(new Date());				
				aplicacao.setConta(conta);
				aplicacao.setValorAtual(aplicacao.getValorInicial());
				repositorioDeAplicacoes.grava(aplicacao);
				repositorioDeLancamentos.grava(new Lancamento(0, conta, -aplicacao.getValorInicial(), 
						new Date(), "Aplicação em CDB", TipoDeLancamento.Transferencia, 
						new Date().hashCode()));
				result.redirectTo(AplicacoesController.class).situacao();
			}
		} else {
			result.redirectTo(Bankline.class).login();		
		}		
		validator.onErrorUsePageOf(AplicacoesController.class).investir();		
	}	
	
	@Path("/cdb/resgatar")	
	public void resgatar(final int id){
		if (sessao.isLogada()){
			final Aplicacao aplicacao = repositorioDeAplicacoes.buscaAplicacao(id);
			final Conta conta = sessao.getContaLogada();
			Double valor = aplicacao.getValorAtual();
			if (!aplicacao.isResgatavel()){
				final Taxas taxa = repositorioDeAdministradores.obterTaxas();
				taxa.getJurosPenalidadeCDB();
				valor = valor - (valor * (taxa.getJurosPenalidadeCDB()/100));				
			}
			final Lancamento lancamento = new Lancamento(0, conta, valor, new Date(), "Resgate de aplicação", TipoDeLancamento.Transferencia, new Date().hashCode());
			repositorioDeLancamentos.grava(lancamento);
			repositorioDeAplicacoes.exclui(aplicacao);
			result.redirectTo(ContasController.class).extrato();			
		} else {
			result.redirectTo(Bankline.class).login();		
		}		
		validator.onErrorUsePageOf(AplicacoesController.class).investir();		
	}
	
	@SuppressWarnings("deprecation")
	@Path("/cdb/situacao")	
	public List<Aplicacao> situacao(){
		if (sessao.isLogada()){
			final Conta conta = sessao.getContaLogada();
			final List<Aplicacao> aplicacoesDaConta = repositorioDeAplicacoes.carregaAplicacoesDaConta(conta);
			for(final Aplicacao aplicacao: aplicacoesDaConta){
				final int month1 = aplicacao.getDataDeAplicacao().getMonth();
				final int month2 = new Date().getMonth();
				int result = month2 - month1;
				
				if (month2 > month1) {
					result = month2 - month1;
				} else {
					result = month1 - month2;					
				}
				
				final Taxas taxas = repositorioDeAdministradores.obterTaxas();
				double valorReal = aplicacao.getValorInicial();
				for(int z = 0; z < result; z++){
					valorReal = valorReal * (1 + taxas.getJurosCDB());
				}
				aplicacao.setValorAtual(valorReal);
				
			}
			return aplicacoesDaConta;
		} else {
			result.redirectTo(Bankline.class).login();		
			return null;
		}
	}	
	
	@Path("/poupanca")	
	public void poupanca(){}
	
	@Post
	@Path("/poupanca/novo")	
	public void novo(final Transferencia transferencia){
		if (sessao.isLogada()){
			final Conta contaDebitada = this.sessao.getContaLogada();
			final String codigoDaAgencia = transferencia.getCodigoDaAgencia();
			final String codigoDaConta = transferencia.getCodigoDaConta();
			
			final Date dataDeAplicacao = new Date();
			if (transferencia.getData() == null){
				transferencia.setData(dataDeAplicacao);
			}
			
			if (transferencia.getData().before(dataDeAplicacao)){
				validator.add(new ValidationMessage("Uma transferência não pode ser agendada para o passado", "transferencia.data"));				
			} else {
				if(codigoDaAgencia.equalsIgnoreCase(contaDebitada.getCodigoDaAgencia()) && codigoDaConta.equalsIgnoreCase(contaDebitada.getCodigoDaConta()) ){
					validator.add(new ValidationMessage("Uma transferência não pode ser realizada para a própria conta", "transferencia.codigoDaConta"));
				} else {
					final Conta contaCreditada = repositorioDeContas.carrega(codigoDaAgencia, codigoDaConta);
					if (contaCreditada == null){
						validator.add(new ValidationMessage("Conta inexistente", "transferencia.codigoDaConta"));			
					} else {
						if (!contaCreditada.isPoupanca()){
							validator.add(new ValidationMessage("Apenas contas poupança podem receber aplicações", "transferencia.codigoDaConta"));							
						} else {
							final int codigo = dataDeAplicacao.hashCode();
							repositorioDeLancamentos.grava(new Lancamento(0, contaDebitada, -transferencia.getValor(), transferencia.getData(), 
									transferencia.getDescricao(), TipoDeLancamento.Transferencia, codigo));
							repositorioDeLancamentos.grava(new Lancamento(0, contaCreditada, transferencia.getValor(), transferencia.getData(), 
									transferencia.getDescricao(), TipoDeLancamento.Transferencia, codigo));
							result.redirectTo(ContasController.class).extrato();
						}
					}		
				}	
			}
			
			validator.onErrorUsePageOf(TransferenciasController.class).index();			
		} else {
			result.redirectTo(Bankline.class).login();
		}
	}		
	
}
