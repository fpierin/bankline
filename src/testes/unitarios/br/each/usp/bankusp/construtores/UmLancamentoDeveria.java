package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

public class UmLancamentoDeveria {
	
	@Test
	public void gerarUmaInstanciaConcretaDeUmLancamento() throws Exception {
		final Lancamento valorEncontrado = Um.Lancamento().novo();
		assertThat(valorEncontrado , is(notNullValue()));
	}
	
	@Test
	public void obterUmLancamentoComIdConhecido() throws Exception {
		final int valorEsperado = 8;
		final int valorEncontrado = new UmLancamento().comId(valorEsperado).novo().getId();
		assertThat(valorEncontrado, is(valorEsperado));		
	}
	

	@Test
	public void obterUmLancamentoComContaConhecido() throws Exception {
		final Conta valorEsperado = Uma.Conta().nova();
		final Conta valorEncontrado = new UmLancamento().naConta(valorEsperado).novo().getConta();
		assertThat(valorEncontrado, is(valorEsperado));		
	}
	
	@Test
	public void obterUmLancamentoComDescricaoConhecido() throws Exception {
		final String valorEsperado = "descricao qualquer";
		final String valorEncontrado = new UmLancamento().descritoComo(valorEsperado).novo().getDescricao();
		assertThat(valorEncontrado, is(valorEsperado));		
	}		
	
	@Test
	public void obterUmLancamentoComValorConhecido() throws Exception {
		final Double valorEsperado = 14.12;
		final Double valorEncontrado = new UmLancamento().deValor(valorEsperado).novo().getValor();
		assertThat(valorEncontrado, is(valorEsperado));		
	}
	
	@Test
	public void obterUmLancamentoComDataConhecida() throws Exception {
		final Date valorEsperado = new Date();
		final Date valorEncontrado = new UmLancamento().naData(valorEsperado).novo().getData();
		assertThat(valorEncontrado, is(valorEsperado));		
	}				

}
