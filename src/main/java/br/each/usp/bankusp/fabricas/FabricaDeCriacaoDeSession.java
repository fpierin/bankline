package br.each.usp.bankusp.fabricas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class FabricaDeCriacaoDeSession implements ComponentFactory<Session>{

	private final SessionFactory sessionFactory;
	private Session session;
	
	public FabricaDeCriacaoDeSession(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@PostConstruct
	public void create(){
		this.session = sessionFactory.openSession();
	}
	
	public Session getInstance() {
		return session;
	}

	@PreDestroy
	public void destroy(){
		this.session.close();
	}

}
