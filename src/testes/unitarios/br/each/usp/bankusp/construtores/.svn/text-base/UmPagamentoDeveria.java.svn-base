package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import br.each.usp.bankusp.representacoes.Pagamento;

public class UmPagamentoDeveria {
	
	@Test
	public void gerarUmaInstanciaConcretaDeumObjetoPagamento() throws Exception {
		final Pagamento valorEncontrado = new UmPagamento().novo();
		assertThat(valorEncontrado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmObjetoPagamentoConcretoComValorConhecido() throws Exception {
		final double valorEsperado = 12.48;
		final double valorEncontrado = new UmPagamento().deValor(valorEsperado).novo().getValor();
		assertThat(valorEsperado, is(valorEncontrado));
	}					
	
	@Test
	public void gerarUmObjetoPagamentoConcretoComIdConhecido() throws Exception {
		final int valorEsperado = 12;
		final int valorEncontrado = new UmPagamento().comId(valorEsperado).novo().getId();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoPagamentoConcretoComCodigoDeBarrasConhecido() throws Exception {
		final String valorEsperado = "AHHDAJhakdhJKADADJKAJKHDA";
		final String valorEncontrado = new UmPagamento().doCodigoDeBarras(valorEsperado).novo().getCodigoDeBarras();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoPagamentoConcretoComDescricaoConhecida() throws Exception {
		final String valorEsperado = "AHHDAJhakdhJKADADJKAJKHDA";
		final String valorEncontrado = new UmPagamento().descritoComo(valorEsperado).novo().getDescricao();
		assertThat(valorEsperado, is(valorEncontrado));
	}

	@Test
	public void gerarUmObjetoPagamentoConcretoComDataConhecida() throws Exception {
		final Date valorEsperado = new Date();
		final Date valorEncontrado = new UmPagamento().naData(valorEsperado).novo().getData();
		assertThat(valorEsperado, is(valorEncontrado));
	}				

}
