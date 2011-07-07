package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Assert;
import org.junit.Test;


public class UmaConstrutoraEstaticaDeveria {
	
	@Test
	public void gerarUmaInstanciaConcretaDeUmConstrutorFluenteDeUmaConta() throws Exception {
		final UmaConta valorEncontrado = Uma.Conta();
		Assert.assertThat(valorEncontrado , is(notNullValue()));
	}
	
	@Test
	public void gerarUmaInstanciaConcretaDeUmConstrutorFluenteUmaTransferencia() throws Exception {
		final UmaTransferencia valorEncontrado = Uma.Transferencia();
		Assert.assertThat(valorEncontrado , is(notNullValue()));
	}	

}
