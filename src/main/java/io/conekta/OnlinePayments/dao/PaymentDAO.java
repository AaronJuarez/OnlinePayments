package io.conekta.OnlinePayments.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import io.conekta.OnlinePayments.model.Order;

public class PaymentDAO extends AbstractDAO{
	protected static Logger logger = Logger.getLogger("PaymentDAO");
	
	public Order getOrderById(String id) {
		Order order = null;
		
		try {
			Session session = getSession();
			Query q = session.createQuery("From Order" + "where id =:id");
			q.setString(id, "id");
			order = (Order) q.uniqueResult();
			
		}catch(Exception e) {
			logger.error("Could not get credit card info " + e.getMessage());
		}
		
		return order;
	}
	
	public void saveOrder(Order order) {
		persist(order);
	}
}
