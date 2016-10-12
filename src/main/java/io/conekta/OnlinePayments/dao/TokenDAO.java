package io.conekta.OnlinePayments.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import io.conekta.OnlinePayments.model.Token;

public class TokenDAO extends AbstractDAO {
	
	protected static Logger logger = Logger.getLogger("TokenDAO");
	
	public Token getTokenById(String id) {
		Token token = null;
		
		try {
			Session session = getSession();
			Query q = session.createQuery("From Token" + "where id =:id");
			q.setString(id, "id");
			token = (Token) q.uniqueResult();
			
		}catch(Exception e) {
			logger.error("Could not get credit card info " + e.getMessage());
		}
		
		return token;
	}
	
	public void saveToken(Token token) {
		persist(token);
	}

}
