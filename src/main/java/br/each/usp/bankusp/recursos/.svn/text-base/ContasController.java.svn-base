package br.each.usp.bankusp.recursos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.constantes.TipoDeConta;
import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeAdministradores;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeContas;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Sessao;

@Resource
@Path("/bankline/contas")
public class ContasController {

	private final Validator validator;
	private final Result result;
	private final RepositorioDeContas repositorioDeContas;
	private final Sessao sessao;
	private final RepositorioDeAdministradores repositorioDeAdministradores;

	public ContasController(final Result result, 
			final Validator validator, 
			final RepositorioDeContas repositorioDeContas,
			final RepositorioDeAdministradores repositorioDeAdministradores,
			final Sessao sessao) {
		this.result = result;
		this.validator = validator;
		this.repositorioDeContas = repositorioDeContas;
		this.repositorioDeAdministradores = repositorioDeAdministradores;
		this.sessao = sessao;	
	}
	
	public void adiciona(final Conta conta){
		if(repositorioDeContas.existeConta(conta)){
			validator.add(new ValidationMessage("Conta já existente", "conta.codigoDaConta"));
		}
		validator.onErrorUsePageOf(ContasController.class).novo();
		repositorioDeContas.adiciona(conta);
		result.redirectTo(ContasController.class).extrato();
	}

	public void novo() {}
	
	public Conta listaMovimentacao(){
		return this.sessao.getContaLogada();
	}
	
	@Path("/")
	public void index(){
		result.redirectTo(ContasController.class).extrato();
	}	
	
	public Conta extrato(){
		if (sessao.isLogada()){
			final Conta contaLogada = sessao.getContaLogada();
			final Conta carregaContaComLancamentos = repositorioDeContas.carregaContaComLancamentos(contaLogada);
			final Date dataDeCriacao = carregaContaComLancamentos.getDataDeCriacao();

			final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
			double numeroDeMeses = 0.0;
			try{
				numeroDeMeses = (double)((new Date().getTime() - dataDeCriacao.getTime()) / MES_EM_MILISEGUNDOS);
			} catch (final Exception e){
				numeroDeMeses = 0.0;
			}
	        
			for (int i = 0; i < numeroDeMeses; i ++){
				final Calendar calendar = new GregorianCalendar();
				calendar.setTime(dataDeCriacao);
		        calendar.add(Calendar.MONTH, i);
		        if (carregaContaComLancamentos.getTipoDeConta().equals(TipoDeConta.Poupanca)){
					carregaContaComLancamentos.getLancamentos().add(new Lancamento(0, carregaContaComLancamentos, 
							(carregaContaComLancamentos.getSaldoAtual() * repositorioDeAdministradores.obterTaxas().getJurosPoupanca()), 
							new Date(calendar.getTime().getTime()), "rendimento de Juros", TipoDeLancamento.Pagamento, new Date().hashCode()));		        	
		        } else if (carregaContaComLancamentos.getTipoDeConta().equals(TipoDeConta.Corrente)){
					carregaContaComLancamentos.getLancamentos().add(new Lancamento(0, carregaContaComLancamentos, 
							- repositorioDeAdministradores.obterTaxas().getManutencaoDeConta(), 
							new Date(calendar.getTime().getTime()), "Taxa de manutenção", TipoDeLancamento.Pagamento, new Date().hashCode()));		        	
		        }

			}
			
			return carregaContaComLancamentos;
		}
		return this.sessao.getContaLogada();
	}
		
}
