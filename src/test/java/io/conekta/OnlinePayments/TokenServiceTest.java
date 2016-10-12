package io.conekta.OnlinePayments;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import io.conekta.OnlinePayments.model.CardInfo;
import io.conekta.OnlinePayments.service.TokenService;
import io.conekta.OnlinePayments.model.Token;

public class TokenServiceTest {
	CardInfo cardInfo;
	TokenService tokenService = new TokenService();
	
	@Before
	public void setUp() {
		cardInfo = new CardInfo();
		cardInfo.setName("Aaron Juarez");
		cardInfo.setCardNumber("3456984503851759");
		cardInfo.setCvc("456");
		cardInfo.setDate(new Date());
	}

	@Test
	public void test() {
		Token token = tokenService.getToken(cardInfo); 
		assertNotNull(token);
	}

}
