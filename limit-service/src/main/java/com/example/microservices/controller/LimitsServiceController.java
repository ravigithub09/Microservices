package com.example.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.config.Configuration;

@RestController
public class LimitsServiceController {

	@Autowired
	 Configuration configuration;
	
	@GetMapping("/getLimit")
	public Configuration retrieveLimits() {
		return new Configuration(configuration.getMinimum(),configuration.getMaximum());
	}
	
}
