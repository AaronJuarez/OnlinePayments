package io.conekta.OnlinePayments.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(Object object) {
		getSession().persist(object);
	}
	
	public void delete(Object object) {
		getSession().delete(object);
	}
}
