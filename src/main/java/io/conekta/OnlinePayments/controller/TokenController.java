package io.conekta.OnlinePayments.controller;

import io.conekta.OnlinePayments.model.CardInfo;
import io.conekta.OnlinePayments.model.Token;
import io.conekta.OnlinePayments.service.TokenService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



public class TokenController {
	
	protected static Logger logger = Logger.getLogger("TokenController");

	@Resource(name = "tokenService")
	private TokenService tokenService;
	
	
	@RequestMapping(value = "/token", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	Token getToken(@RequestBody CardInfo card) {
		
		Token token = tokenService.getToken(card);
		if(token != null) {
			return token;
		}
		
		return null;
	}

}
