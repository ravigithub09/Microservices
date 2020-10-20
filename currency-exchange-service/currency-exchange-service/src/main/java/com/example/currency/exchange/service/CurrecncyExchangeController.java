package com.example.currency.exchange.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrecncyExchangeController {

	private static final  Logger LOGGER = LoggerFactory.getLogger(CurrecncyExchangeController.class);
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;
	//http://localhost:8000/exchageService/from/USD/to/INR
	@GetMapping("/exchageService/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		//ExchangeValue exchangeValue = new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		LOGGER.info("{}",exchangeValue);
		return exchangeValue;
	}
}
