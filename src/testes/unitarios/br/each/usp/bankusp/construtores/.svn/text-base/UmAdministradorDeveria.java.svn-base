package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import br.each.usp.bankusp.representacoes.Administrador;

public class UmAdministradorDeveria {
	
	@Test
	public void geraUmaInstanciaConcretaDeUmObjetoAdministrador() throws Exception {
		final Administrador valorEncontrado = new UmAdministrador().novo();
		Assert.assertThat(valorEncontrado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmObjetoAdministradorConcretoComLoginConhecido() throws Exception {
		final String valorEsperado = "login qualquer";
		final String valorEncontrado = new UmAdministrador().doLogin(valorEsperado).novo().getLogin();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoAdministradorConcretoComIdConhecida() throws Exception {
		final int valorEsperado = 7;
		final int valorEncontrado = new UmAdministrador().comId(valorEsperado).novo().getId();
		assertThat(valorEsperado, is(valorEncontrado));
	}				
	
	@Test
	public void gerarUmObjetoAdministradorConcretoComSenhaConhecida() throws Exception {
		final String valorEsperado = "senha qualquer";
		final String valorEncontrado = new UmAdministrador().comSenha(valorEsperado).novo().getSenha();
		assertThat(valorEsperado, is(valorEncontrado));
	}			
	
	@Test
	public void gerarUmObjetoAdministradorConcretoComNomeConhecido() throws Exception {
		final String valorEsperado = "nome qualquer";
		final String valorEncontrado = new UmAdministrador().conhecidoComo(valorEsperado).novo().getNome();
		assertThat(valorEsperado, is(valorEncontrado));
	}		

}
