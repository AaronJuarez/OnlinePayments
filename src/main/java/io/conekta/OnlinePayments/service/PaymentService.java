package io.conekta.OnlinePayments.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import io.conekta.OnlinePayments.model.Order;
import io.conekta.OnlinePayments.model.Token;
import io.conekta.OnlinePayments.dao.PaymentDAO;
import io.conekta.OnlinePayments.dao.TokenDAO;;

public class PaymentService {
	protected static Logger logger = Logger.getLogger("PaymentService");
	
	@Autowired
	TokenDAO tokenDAO;
	@Autowired
	PaymentDAO paymentDAO;
	
	public String setPayment(Order order) {
		String status = "";
		String tkn = order.getCard();
		Token token = tokenDAO.getTokenById(tkn);
		if(token != null) {
			status = "OK";
			paymentDAO.saveOrder(order);
		}
		
		return status;
	}
}
