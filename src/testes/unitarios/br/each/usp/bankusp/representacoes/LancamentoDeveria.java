package br.each.usp.bankusp.representacoes;

import static org.hamcrest.core.Is.is;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.each.usp.bankusp.construtores.Um;

public class LancamentoDeveria {
	
	@Test
	public void identificaUmLancamentoComDataIgualADataAtualComoUmLancamentoPassado() throws Exception {
		final Date dataConhecida = new Date();
		final boolean futuro = Um.Lancamento().naData(dataConhecida).novo().isFuturo();
		Assert.assertThat(futuro, is(false));
	}		
	
	@Test
	public void identificaUmLancamentoComDataMenorQueADataAtualComoUmLancamentoPassado() throws Exception {
		final DateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");
		final Date dataConhecida = formatoDeData.parse("01/02/2000");
		final boolean futuro = Um.Lancamento().naData(dataConhecida).novo().isFuturo();
		Assert.assertThat(futuro, is(false));		
	}
	
	@Test
	public void identificaUmLancamentoComDataMaiorQueADataAtualComoUmLancamentoFuturo() throws Exception {
		final DateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");
		final Date dataConhecida = formatoDeData.parse("22/11/2040");
		final boolean futuro = Um.Lancamento().naData(dataConhecida).novo().isFuturo();
		Assert.assertThat(futuro, is(true));		
	}	

}
