package io.conekta.OnlinePayments;

import static org.junit.Assert.*;

import io.conekta.OnlinePayments.model.Token;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import io.conekta.OnlinePayments.utils.CreateToken;

public class CreateTokenTest {
	CreateToken createToken;
	Date date;

	@Before
	public void setUp() {
		createToken = new CreateToken();
		date = new Date();
	}
	
	@Test
	public void test() {
		Token token = CreateToken.getToken("Aaron", "12345", "123", date);
		assertNotNull(token);
	}

}
