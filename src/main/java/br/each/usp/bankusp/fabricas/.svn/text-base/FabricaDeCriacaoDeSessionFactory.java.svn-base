package br.each.usp.bankusp.fabricas;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.each.usp.bankusp.modelo.leitores.LeitorDePropriedadesDeConfiguracao;

@Component
@ApplicationScoped
public class FabricaDeCriacaoDeSessionFactory implements ComponentFactory<SessionFactory> {

	private SessionFactory sessionFactory;
	private final LeitorDePropriedadesDeConfiguracao leitorDePropriedades;
	
	public FabricaDeCriacaoDeSessionFactory(final LeitorDePropriedadesDeConfiguracao leitorDePropriedades) {
		this.leitorDePropriedades = leitorDePropriedades; 
	}

	@PostConstruct
	public void buildSessionFactory() {
		this.sessionFactory = new FabricaDeSessionFactory(leitorDePropriedades).build();  
	}

	@Override
	public SessionFactory getInstance() {
		return sessionFactory;
	}
	
	@PreDestroy
	public void closeSessionFactory() {
		this.sessionFactory.close();
	}	


}
