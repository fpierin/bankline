package br.each.usp.bankusp.representacoes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.each.usp.bankusp.construtores.Um;
import br.each.usp.bankusp.construtores.Uma;

public class SessaoDeveria {
	
	@Test
	public void retornarOClienteConhecidoDaContaLogada() throws Exception {
		final Cliente cliente = Um.Cliente().novo();
		final Conta conta = Uma.Conta().doCliente(cliente).nova();
		final Sessao sessao = new Sessao();
		sessao.login(conta);
		assertThat(conta.getCliente(), is(cliente));
	}
	
	@Test
	public void retornarONomeDoClienteDaContaLogada() throws Exception {
		final Cliente cliente = Um.Cliente().novo();
		final Conta conta = Uma.Conta().doCliente(cliente).nova();
		final Sessao sessao = new Sessao();
		sessao.login(conta);
		assertThat(conta.getCliente(), is(cliente));		
	}

}
