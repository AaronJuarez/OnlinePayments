package io.conekta.OnlinePayments.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import io.conekta.OnlinePayments.model.CardInfo;
import io.conekta.OnlinePayments.model.CreditCard;
import io.conekta.OnlinePayments.model.Token;
import io.conekta.OnlinePayments.utils.CipherHandler;
import io.conekta.OnlinePayments.utils.CreateToken;

@Service("tokenService")
public class TokenService {
	CipherHandler cipherHanlder = new CipherHandler();
	protected static Logger logger = Logger.getLogger("TokenService");
	
	public Token getToken(CardInfo card) {
		Token token = null;
		String cardNum = card.getCardNumber();
		String cardName = card.getName();
		String cardCvc = card.getCvc();
		Date cardDate = card.getDate();
		String fstDigit = cardNum.substring(0, 1);
		
		card.setCardNumber(CipherHandler.decryptData(cardNum));
		card.setCvc(CipherHandler.decryptData(cardCvc));
		
		
		try{
			Long numb = Long.parseLong(cardNum);
			numb = Long.parseLong(cardCvc);
		}catch(NumberFormatException ne) {
			logger.debug("credit card number or cvs no numbers");
			return null;
		}
		
		if(cardNum.length() == 16) {
			if(cardCvc.length() == 3) {
				CreditCard creditCard = new CreditCard();
				creditCard.setName(cardName);
				creditCard.setDate(card.getDate());
				creditCard.setBin(cardNum.substring(0, 6));
				creditCard.setLastDigits(cardNum.substring(11));
				
				if(fstDigit.equals("3")) {
					creditCard.setCompany("American Express");
				}else if(fstDigit.equals("4")) {
					creditCard.setCompany("Visa");
				}else if(fstDigit.equals("5")) {
					creditCard.setCompany("Mastercard");
				}
				
				token = CreateToken.getToken(cardName, cardNum, cardCvc, cardDate);
			}
		}
		
		return token;
	}

}
