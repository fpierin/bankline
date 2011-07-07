package br.each.usp.bankusp.interceptadores;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class InterceptadorDeTransacao implements Interceptor {
        
	private final Session session;
        
        public InterceptadorDeTransacao(final Session session) {
            this.session = session;
        }
        
        public void intercept(final InterceptorStack stack, final ResourceMethod method, final Object instance) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                stack.next(method, instance);
                transaction.commit();
            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            }
        }
        
        public boolean accepts(final ResourceMethod method) {
            return true; 
        }
}