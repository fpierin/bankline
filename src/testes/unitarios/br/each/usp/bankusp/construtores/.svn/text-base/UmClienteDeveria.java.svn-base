package br.each.usp.bankusp.construtores;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.each.usp.bankusp.representacoes.Cliente;
import br.each.usp.bankusp.representacoes.Conta;

public class UmClienteDeveria {
	
	@Test
	public void gerarUmObjetoClienteConcreto() throws Exception {
		final Cliente objetoEsperado = new UmCliente().novo();
		assertThat(objetoEsperado, is(notNullValue()));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComIdConhecido() throws Exception {
		final int idEsperado = 2173612;
		final int idEncontrado = new UmCliente().deId(idEsperado).novo().getId();
		assertThat(idEncontrado, is(idEsperado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComEnderecoConhecido() throws Exception {
		final String valorEsperado = "Rua desconhecida";
		final String valorEncontrado = new UmCliente().residenteNoEndereco(valorEsperado).novo().getEndereco();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComNomeConhecido() throws Exception {
		final String valorEsperado = "Josealdo";
		final String valorEncontrado = new UmCliente().deNome(valorEsperado).novo().getNome();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComRGConhecido() throws Exception {
		final String valorEsperado = "32178956782365";
		final String valorEncontrado = new UmCliente().doRG(valorEsperado).novo().getRg();
		assertThat(valorEsperado, is(valorEncontrado));
	}			
	
	@Test
	public void gerarUmObjetoClienteConcretoComCPFConhecido() throws Exception {
		final String valorEsperado = "32178956782365";
		final String valorEncontrado = new UmCliente().doCPF(valorEsperado).novo().getCpf();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComDataDeCadastroConhecido() throws Exception {
		final Date valorEsperado = new Date();
		final Date valorEncontrado = new UmCliente().comDataDeCadastro(valorEsperado).novo().getDataDeCadastro();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComDataDeUltimaAtualizacaoConhecido() throws Exception {
		final Date valorEsperado = new Date();
		final Date valorEncontrado = new UmCliente().comUltimaDataDeAcesso(valorEsperado).novo().getDataDoUltimoAcesso();
		assertThat(valorEsperado, is(valorEncontrado));
	}
	
	@Test
	public void gerarUmObjetoClienteConcretoComContasConhecidas() throws Exception {
		final List<Conta> valorEsperado = new ArrayList<Conta>();
		final List<Conta> valorEncontrado = new UmCliente().donoDaContas(valorEsperado).novo().getContas();
		assertThat(valorEsperado, is(valorEncontrado));
	}						
}
