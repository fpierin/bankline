package br.each.usp.bankusp.provedores;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;
import br.com.caelum.vraptor.util.hibernate.HibernateTransactionInterceptor;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.com.caelum.vraptor.util.hibernate.SessionFactoryCreator;


public class ProviderDoSistema extends SpringProvider {

	@Override
	public void registerCustomComponents(final ComponentRegistry registry) {
	    registry.register(SessionCreator.class, SessionCreator.class); 
	    registry.register(SessionFactoryCreator.class, SessionFactoryCreator.class); 
	    registry.register(HibernateTransactionInterceptor.class, HibernateTransactionInterceptor.class);     
	}
	
}


