package io.conekta.OnlinePayments.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import io.conekta.OnlinePayments.model.CreditCard;

public class CreditCardDAO extends AbstractDAO{
	protected static Logger logger = Logger.getLogger("CreitCardDAO");
	
	public CreditCard getCreditCardById(String id) {
		CreditCard creditCard = null;
		
		try {
			Session session = getSession();
			Query q = session.createQuery("From CreditCard" + "where id =:id");
			q.setString(id, "id");
			creditCard = (CreditCard) q.uniqueResult();
			
		}catch(Exception e) {
			logger.error("Could not get credit card info " + e.getMessage());
		}
		
		return creditCard;
	}
	
	public void saveCreditCard(CreditCard creditCard) {
		persist(creditCard);
	}

}
