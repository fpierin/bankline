package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.each.usp.bankusp.representacoes.Transferencia;


public class UmaTransferenciaDeveria {
	
	@Test
	public void gerarUmaIntanciaConcretaDeUmaTransferencia() throws Exception {
		final Transferencia objetoEncontrado = new UmaTransferencia().nova();
		assertThat(objetoEncontrado, is(notNullValue()));
	}
	
	@Test
	public void obterUmaTransferenciaComAgenciaConhecido() throws Exception {
		final String valorEsperado = "dsajkdhsa";
		final String valorEncontrado = new UmaTransferencia().daAgencia(valorEsperado).nova().getCodigoDaAgencia();
		assertThat(valorEncontrado, is(valorEsperado));
	}
	
	@Test
	public void obterUmaTranferenciaComDescricaoConhecida() throws Exception {
		final String valorEsperado = "Qualquer descricao";
		final String valorEncontrado = new UmaTransferencia().descritaComo(valorEsperado).nova().getDescricao();
		assertThat(valorEncontrado, is(valorEsperado));
	}		
	
	@Test
	public void obterUmaTranferenciaComValorConhecida() throws Exception {
		final double valorEsperado = 112.10;
		final double valorEncontrado = new UmaTransferencia().de(valorEsperado).nova().getValor();
		assertThat(valorEncontrado, is(valorEsperado));
	}	
	
	@Test
	public void obterUmaTranferenciaComContaConhecida() throws Exception {
		final String valorEsperado = "1827";
		final String valorEncontrado = new UmaTransferencia().paraConta(valorEsperado).nova().getCodigoDaConta();
		assertThat(valorEncontrado, is(valorEsperado));
	}	

}
