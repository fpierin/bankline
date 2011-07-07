package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;
import br.each.usp.bankusp.representacoes.Lancamento;

public class UmaContaDeveria {
	
	@Test
	public void gerarUmaIntanciaConcretaDeUmaConta() throws Exception {
		final Conta objetoEncontrado = new UmaConta().nova();
		assertThat(objetoEncontrado, is(notNullValue()));
	}
	
	@Test
	public void obterUmaContaComIdConhecido() throws Exception {
		final int valorEsperado = 3145;
		final int valorEncontrado = new UmaConta().comId(valorEsperado).nova().getId();
		assertThat(valorEncontrado, is(valorEsperado));
	}
	
	@Test
	public void obterUmaContaComCodigoDaAgenciaConhecido() throws Exception {
		final String valorEsperado = "89237";
		final String valorEncontrado = new UmaConta().daAgenciaDeCodigo(valorEsperado).nova().getCodigoDaAgencia();
		assertThat(valorEncontrado, is(valorEsperado));		
	}
	
	@Test
	public void obterUmaContaComCodigoDaContaConhecido() throws Exception {
		final String valorEsperado = "837";
		final String valorEncontrado = new UmaConta().daContaDeCodigo(valorEsperado).nova().getCodigoDaConta();
		assertThat(valorEncontrado, is(valorEsperado));				
	}
	
	@Test
	public void obterUmaContaComSenhaConhecida() throws Exception {
		final String valorEsperado = "837";
		final String valorEncontrado = new UmaConta().protegidaPelaSenha(valorEsperado).nova().getSenha();
		assertThat(valorEncontrado, is(valorEsperado));		
	}
	
	@Test
	public void obterUmaContaDosClientesEsperados() throws Exception {
		final Cliente valorEsperado = Um.Cliente().novo();
		final Cliente valorEncontrado = new UmaConta().doCliente(valorEsperado).nova().getCliente();
		assertThat(valorEncontrado, is(valorEsperado));				
	}
	
	@Test
	public void obterUmaContaDosLancamentosEsperados() throws Exception {
		final List<Lancamento> valorEsperado = new ArrayList<Lancamento>();
		final List<Lancamento> valorEncontrado = new UmaConta().dosLancamentos(valorEsperado).nova().getLancamentos();
		assertThat(valorEncontrado, is(valorEsperado));					
	}					

}
