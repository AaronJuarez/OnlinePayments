package io.conekta.OnlinePayments.utils;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

import io.conekta.OnlinePayments.model.Token;

public class CreateToken {
	
	public static Token getToken(String name, String cardNumber, String cvc, Date date) {
		Token token = new Token();
		
		String tkn = UUID.randomUUID().toString();
		tkn = "tok_" + tkn.substring(0, 8);
	    
	    token.setId(tkn);
	    token.setObject("token");
	    token.setUsed(false);
	    token.setLivemode(true);
	    
		return token;
	}
}
