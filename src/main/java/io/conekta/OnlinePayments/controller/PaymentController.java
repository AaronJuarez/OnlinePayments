package io.conekta.OnlinePayments.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.conekta.OnlinePayments.model.Order;
import io.conekta.OnlinePayments.service.PaymentService;

public class PaymentController {

	protected static Logger logger = Logger.getLogger("PaymentController");

	@Resource(name = "paymentService")
	private PaymentService paymentService;
	
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String setPayment(@RequestBody Order order) {
		return paymentService.setPayment(order);

	}
}
