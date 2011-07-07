package br.each.usp.bankusp.fabricas;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.each.usp.bankusp.modelo.leitores.LeitorDePropriedadesDeConfiguracao;

@SuppressWarnings("deprecation")
public class FabricaDeSessionFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(FabricaDeSessionFactory.class);
	private final LeitorDePropriedadesDeConfiguracao leitorDePropriedades;
	
	public FabricaDeSessionFactory(final LeitorDePropriedadesDeConfiguracao leitorDePropriedades) {
		this.leitorDePropriedades = leitorDePropriedades;
	}
	
	public SessionFactory build(){
		final AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
		final Properties properties = this.propriedadeDefinidaPeloAmbiente();
		configuration.addProperties(properties);
		logger.info("Configurando banco com propriedades: {}", properties);
		return configuration.buildSessionFactory();		
	}

	private Properties propriedadeDefinidaPeloAmbiente() {
		return this.estamosNoAmbienteDeProducao()? this.retornaAsPropriedadesDeProducao() :
			   this.estamosNaIntegracaoContinua()? this.retornaAsPropriedadesDeIntegracaoContinua() : 
				   							  this.retornaAsPropriedadesPadrao();
	}

	private boolean estamosNoAmbienteDeProducao() {
		return ((System.getProperty("bankusp.environment") != null) && 
				(System.getProperty("bankusp.environment").equalsIgnoreCase("Producao")));
	}

	private boolean estamosNaIntegracaoContinua() {
		return ((System.getProperty("bankusp.environment") != null) && 
				(System.getProperty("bankusp.environment").equalsIgnoreCase("IntegracaoContinua")));
	}

	private Properties retornaAsPropriedadesDeProducao() {
		logger.info("Ambiente configurado: producao");	
		return this.propriedadesDoAmbienteConfigurado(
				this.leitorDePropriedades.getValorDaPropriedade("producao.bancoDeDados.jdbcUrl"),
				this.leitorDePropriedades.getValorDaPropriedade("producao.bancoDeDados.usuario"),
				this.leitorDePropriedades.getValorDaPropriedade("producao.bancoDeDados.senha"),
				this.leitorDePropriedades.getValorDaPropriedade("producao.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("producao.hibernate.show_sql"),
				this.leitorDePropriedades.getValorDaPropriedade("producao.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("producao.hibernate.hbm2ddl"));
	}

	private Properties retornaAsPropriedadesPadrao() {	
		logger.info("Ambiente configurado: desenvolvimento");			
		return this.propriedadesDoAmbienteConfigurado(
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.bancoDeDados.jdbcUrl"),
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.bancoDeDados.usuario"),
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.bancoDeDados.senha"),
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.hibernate.show_sql"),
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("desenvolvimento.hibernate.hbm2ddl"));
	}

	private Properties retornaAsPropriedadesDeIntegracaoContinua() {
		logger.info("Ambiente configurado: integracao continua");
		return this.propriedadesDoAmbienteConfigurado(
				this.leitorDePropriedades.getValorDaPropriedade("testes.bancoDeDados.jdbcUrl"),
				this.leitorDePropriedades.getValorDaPropriedade("testes.bancoDeDados.usuario"),
				this.leitorDePropriedades.getValorDaPropriedade("testes.bancoDeDados.senha"),
				this.leitorDePropriedades.getValorDaPropriedade("testes.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("testes.hibernate.show_sql"),
				this.leitorDePropriedades.getValorDaPropriedade("testes.hibernate.show_sql"),				
				this.leitorDePropriedades.getValorDaPropriedade("testes.hibernate.hbm2ddl"));
	}

	private Properties propriedadesDoAmbienteConfigurado(
			final String hibernateConnectionUrl,
			final String hibernateConnectionUsername,
			final String hibernateConnectionPassword,
			final String hibernateShowSQL, 
			final String hibernateFormatSQL,
			final String hibernateGenerateDDL,
			final String hibernateHdm2DDL) {
		final Properties properties = new Properties();
		properties.setProperty("hibernate.connection.url", hibernateConnectionUrl);
		properties.setProperty("hibernate.connection.username", hibernateConnectionUsername);
		properties.setProperty("hibernate.connection.password", hibernateConnectionPassword);
		properties.setProperty("hibernate.format_sql", hibernateFormatSQL);
		properties.setProperty("hibernate.generateDdl", hibernateGenerateDDL);
		properties.setProperty("hibernate.show_sql", hibernateShowSQL);
		properties.setProperty("hibernate.hbm2ddl.auto", hibernateHdm2DDL);				
		return properties;
	}
}
