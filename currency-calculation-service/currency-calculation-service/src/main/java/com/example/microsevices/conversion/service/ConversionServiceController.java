package com.example.microsevices.conversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConversionServiceController {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(ConversionServiceController.class);
	
	@Autowired
	CurrencyConversionFeignProxyService proxy;
	
	//http://localhost:8100/currency-conversion/from/{from}/to/{to}/quantity/{quantity}
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrncyConversionBean doCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrncyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/exchageService/from/{from}/to/{to}", 
				CurrncyConversionBean.class	, uriVariables);
		CurrncyConversionBean currncyConversionBean = responseEntity.getBody();
		return new CurrncyConversionBean(currncyConversionBean.getId(), from, to,
				currncyConversionBean.getExchange(), quantity,quantity.multiply(currncyConversionBean.getExchange()) , currncyConversionBean.getPort());
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrncyConversionBean doCurrencyConversionFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		CurrncyConversionBean currncyConversionBean = proxy.getExchangeValue(from, to);
		LOGGER.info("{}",currncyConversionBean);
		return new CurrncyConversionBean(currncyConversionBean.getId(), from, to,
				currncyConversionBean.getExchange(), quantity,quantity.multiply(currncyConversionBean.getExchange()) , currncyConversionBean.getPort());
	}

}
