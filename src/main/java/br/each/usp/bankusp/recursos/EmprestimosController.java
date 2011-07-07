package br.each.usp.bankusp.recursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.each.usp.bankusp.constantes.Modalidade;
import br.each.usp.bankusp.constantes.TipoDeLancamento;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeEmprestimos;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeLancamentos;
import br.each.usp.bankusp.modelo.repositorios.RepositorioDeParcelas;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Emprestimo;
import br.each.usp.bankusp.representacoes.Lancamento;
import br.each.usp.bankusp.representacoes.Parcela;
import br.each.usp.bankusp.representacoes.Sessao;

@Resource
@Path("/bankline/emprestimos")
public class EmprestimosController {
	
	private final Result result;
	private final Sessao sessao;
	private final Validator validator;
	private final RepositorioDeEmprestimos repositorioDeEmprestimos;
	private final RepositorioDeParcelas repositorioDeParcelas;
	private final RepositorioDeLancamentos repositorioDeLancamentos;

	public EmprestimosController(final Sessao sessao, final Result result, final Validator validator, 
			final RepositorioDeEmprestimos repositorioDeEmprestimos, final RepositorioDeParcelas repositorioDeParcelas, final RepositorioDeLancamentos repositorioDeLancamentos){
		this.sessao = sessao;
		this.result = result;
		this.validator = validator;
		this.repositorioDeEmprestimos = repositorioDeEmprestimos;
		this.repositorioDeParcelas = repositorioDeParcelas;
		this.repositorioDeLancamentos = repositorioDeLancamentos;
	}
	
	@Path("/")
	public void index(){}
	
	@Path("/novo")
	public void novo(){}
	
	@Path("/situacao")
	public List<Emprestimo> situacao(){
		if (sessao.isLogada()){
			final Conta conta = sessao.getContaLogada();
			return repositorioDeEmprestimos.carregaEmprestimosDaConta(conta);
		} else {
			result.forwardTo(Bankline.class).login();
			return null;
		}
	}
	
	public Emprestimo confirma(final Emprestimo emprestimo){
		final Conta conta = sessao.getContaLogada();		
		if (contaJaPossuiEmprestimo(conta)){
			validator.add(new ValidationMessage("A conta já possui um empréstimo.", "conta.possuiEmprestimo"));
			validator.onErrorUsePageOf(EmprestimosController.class).situacao();
		} else {
			emprestimo.setConta(conta);
			final Modalidade modalidade = emprestimo.getModalidade();
			final int quantidadeDeParcelas = obterQuantidadeDeParcelasDaModalidade(modalidade);			
			final List<Parcela> parcelas = parcelas(emprestimo, quantidadeDeParcelas);
			emprestimo.setParcelas(parcelas);
		}
		return emprestimo;
	}
	
	private boolean contaJaPossuiEmprestimo(final Conta conta) {
		final List<Emprestimo> emprestimosDaConta = repositorioDeEmprestimos.carregaEmprestimosDaConta(conta);
		if (emprestimosDaConta != null){
			for(final Emprestimo emprestimo: emprestimosDaConta){
				if (!emprestimo.isQuitado()){
					return true;
				}
			}
		}
		return false;
	}

	public Emprestimo realiza(final Emprestimo emprestimo){
		validator.onErrorUsePageOf(EmprestimosController.class).index();		
		final Conta contaLogada = sessao.getContaLogada();
		if (contaJaPossuiEmprestimo(contaLogada)){
			validator.add(new ValidationMessage("A conta já possui um empréstimo.", "conta.possuiEmprestimo"));
			validator.onErrorUsePageOf(EmprestimosController.class).situacao();
		} else {
			emprestimo.setConta(contaLogada);
			final Modalidade modalidade = emprestimo.getModalidade();
			final int quantidadeDeParcelas = obterQuantidadeDeParcelasDaModalidade(modalidade);			
			final List<Parcela> parcelas = parcelas(emprestimo, quantidadeDeParcelas);
			emprestimo.setParcelas(parcelas);
			repositorioDeEmprestimos.grava(emprestimo);
			repositorioDeLancamentos.grava(new Lancamento(0, contaLogada, emprestimo.getValor(), new Date(), "Empréstimo bancário", TipoDeLancamento.Emprestimo, new Date().hashCode()));
			result.forwardTo(EmprestimosController.class).situacao();
		}
		return emprestimo;
	}	
	
	public void quitarParcela(final int id){
		final Parcela parcela = repositorioDeParcelas.obterParcela(id);
		parcela.quitar();
		final int codigo = new Date().hashCode();
		final Lancamento lancamento = new Lancamento(0, sessao.getContaLogada(), -parcela.getValor(), new Date(), "Pagamento de parcela " + parcela.getNumero(), TipoDeLancamento.Pagamento, codigo);
		repositorioDeLancamentos.grava(lancamento);
		repositorioDeParcelas.atualiza(parcela);
		result.forwardTo(EmprestimosController.class).situacao();		
	}

	private int obterQuantidadeDeParcelasDaModalidade(final Modalidade modalidade) {
		switch (modalidade) {
		case Em12: return 12;
		case Em24: return 24;		
		case Em36: return 36;
		case Em48: return 48;		
		default: return 0;
		}
	}

	private List<Parcela> parcelas(final Emprestimo emprestimo, final int quantidadeDeParcelas) {
		final List<Parcela> parcelas = new ArrayList<Parcela>();
		final Double jurosDoEmprestimo = 1.005;
		final Double valorDoEmprestimo = emprestimo.getValor();
		final Double valorComJuros = valorDoEmprestimo * jurosDoEmprestimo;
		final Double valorDaParcela = valorComJuros / quantidadeDeParcelas;
		
		Date novaData = new Date();
		for(int i = 1; i <= quantidadeDeParcelas; i++){
			novaData = obterProximaDataDePagamento(novaData);
			parcelas.add(new Parcela(0, valorDaParcela, i, false, emprestimo, novaData));
		}
		return parcelas ;
	}

	private Date obterProximaDataDePagamento(final Date novaData) {
        final GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(novaData);
        calendar.add(Calendar.MONTH, 1);
		return new Date(calendar.getTime().getTime());
	}
	

}
