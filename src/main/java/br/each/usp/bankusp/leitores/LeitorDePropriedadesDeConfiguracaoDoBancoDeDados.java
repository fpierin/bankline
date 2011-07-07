package br.each.usp.bankusp.leitores;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.each.usp.bankusp.modelo.leitores.LeitorDePropriedadesDeConfiguracao;

@ApplicationScoped
@Component
public class LeitorDePropriedadesDeConfiguracaoDoBancoDeDados implements LeitorDePropriedadesDeConfiguracao {
	
	public LeitorDePropriedadesDeConfiguracaoDoBancoDeDados() {}

	@Override
	public String getValorDaPropriedade(final String chaveDaPropriedade) {
		final InputStream inputStream = LeitorDePropriedadesDeConfiguracaoDoBancoDeDados.class.getResourceAsStream("/db.properties");
		final Properties properties = new Properties();
		try {
			properties.load(inputStream);
			return properties.getProperty(chaveDaPropriedade);			
		} catch (IOException exception) {
			exception.printStackTrace();
			throw new RuntimeException(exception);
		}		
	}

}



