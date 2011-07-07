package br.each.usp.bankusp.representacoes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.construtores.Uma;

public class ContaDeveria {
	
	@Test
	public void retornarONomeConhecidoDeumCliente() throws Exception {
		final String valorEsperado = "Samira";
		final Cliente clienteConhecido = Um.Cliente().deNome(valorEsperado).novo();
		final String valorEncontrado = Uma.Conta().doCliente(clienteConhecido).nova().getNomeDoCliente();
		assertThat(valorEncontrado, is(valorEsperado));
	}
	
	@Test
	public void obterUmaQuantidadeZeroDeUmaContaSemLancamentos() throws Exception {
		final Conta contaSemLancamentos = Uma.Conta().nova();
		final int totalDeLancamentosEncontrado = contaSemLancamentos.getTotalDeLancamentos();
		assertThat(totalDeLancamentosEncontrado, is(0));
	}
	
	@Test
	public void obterUmaQuantidadeConhecidaDeUmaContaComQuantidadeDeLancamentosConhecida() throws Exception {
		final List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos.add(Um.Lancamento().deValor(10.0)
									   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2006"))
									   .novo());
		lancamentos.add(Um.Lancamento().deValor(20.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2007"))
				   .novo());
		lancamentos.add(Um.Lancamento().deValor(30.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2017"))
				   .novo());						
		lancamentos.add(Um.Lancamento().deValor(30.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2017"))
				   .novo());				
		final Conta contaSemLancamentos = Uma.Conta().dosLancamentos(lancamentos).nova();
		final int totalDeLancamentosEncontrado = contaSemLancamentos.getTotalDeLancamentos();
		assertThat(totalDeLancamentosEncontrado, is(4));
	}	
	
	@Test
	public void obterUmSaldoAtualConhecidoDeUmaListaDeLancamentosVazia() throws Exception {
		final Conta contaSemLancamentos = Uma.Conta().nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoAtual();
		assertThat(totalDeLancamentosEncontrado, is(0.0));		
	}
	
	@Test
	public void obterUmSaldoFuturoConhecidoDeUmaListaDeLancamentosVazia() throws Exception {
		final Conta contaSemLancamentos = Uma.Conta().nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoFuturo();
		assertThat(totalDeLancamentosEncontrado, is(0.0));		
	}
	
	@Test
	public void obterUmSaldoTotalConhecidoDeUmaListaDeLancamentosVazia() throws Exception {
		final Conta contaSemLancamentos = Uma.Conta().nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoTotal();
		assertThat(totalDeLancamentosEncontrado, is(0.0));		
	}		
	
	@Test
	public void obterUmSaldoAtualConhecidoDeUmaListaDeLancamentosConhecidos() throws Exception {
		final List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos.add(Um.Lancamento().deValor(10.0)
									   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2006"))
									   .novo());
		lancamentos.add(Um.Lancamento().deValor(20.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2007"))
				   .novo());
		lancamentos.add(Um.Lancamento().deValor(30.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2017"))
				   .novo());				
		final Conta contaSemLancamentos = Uma.Conta().dosLancamentos(lancamentos).nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoAtual();
		assertThat(totalDeLancamentosEncontrado, is(30.0));		
	}
	
	@Test
	public void obterUmSaldoFuturoConhecidoDeUmaListaDeLancamentosConhecidos() throws Exception {
		final List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos.add(Um.Lancamento().deValor(10.10)
									   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2006"))
									   .novo());
		lancamentos.add(Um.Lancamento().deValor(20.20)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2007"))
				   .novo());
		lancamentos.add(Um.Lancamento().deValor(40.40)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2017"))
				   .novo());				
		final Conta contaSemLancamentos = Uma.Conta().dosLancamentos(lancamentos).nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoFuturo();
		assertThat(totalDeLancamentosEncontrado, is(40.40));		
	}
	
	@Test
	public void obterUmSaldoTotalConhecidoDeUmaListaDeLancamentosConhecidos() throws Exception {
		final List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos.add(Um.Lancamento().deValor(10.0)
									   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2006"))
									   .novo());
		lancamentos.add(Um.Lancamento().deValor(20.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2007"))
				   .novo());
		lancamentos.add(Um.Lancamento().deValor(40.0)
				   .naData(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2007"))
				   .novo());				
		final Conta contaSemLancamentos = Uma.Conta().dosLancamentos(lancamentos).nova();
		final double totalDeLancamentosEncontrado = contaSemLancamentos.getSaldoTotal();
		assertThat(totalDeLancamentosEncontrado, is(70.0));		
	}		
	

}
