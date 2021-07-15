package com.example.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.example.currencyexchangeservice.bean.CurrencyExchange;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;


@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to){
		
		CurrencyExchange exchangeValue = 
				repository.findByFromAndTo(from, to);
		
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;
	}
}
