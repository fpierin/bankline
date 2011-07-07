package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UmConstrutorEstaticoDeveria {

	@Test
	public void gerarUmConstrutorDeClienteConcreto() throws Exception {
		final UmCliente objetoEncontrado = Um.Cliente();
		assertThat(objetoEncontrado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmConstrutorDeUmLancamentoConcreto() throws Exception {
		final UmLancamento objetoEncontrado = Um.Lancamento();
		assertThat(objetoEncontrado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmConstrutorDeUmAdministradorConcreto() throws Exception {
		final UmAdministrador objetoEncontrado = Um.Administrador();
		assertThat(objetoEncontrado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmConstrutorDeUmPagamentoConcreto() throws Exception {
		final UmPagamento objetoEncontrado = Um.Pagamento();
		assertThat(objetoEncontrado, is(notNullValue()));
	}			
	
}
