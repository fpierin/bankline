package br.each.usp.bankusp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class Transactor<T> {

	private final SessionFactory sessionFactory;

	public Transactor(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public T go() throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			T result = dentroDeUmaTransacao(session);
			transaction.commit();
			return result;
		}
		catch (Exception ex) {
			if (transaction != null && transaction.isActive())
				transaction.rollback();
			throw ex;
		}
		finally {
			if (session != null) {
				try {
					session.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public abstract T dentroDeUmaTransacao(final Session session);

}
