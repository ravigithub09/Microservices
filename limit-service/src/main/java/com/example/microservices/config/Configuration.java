package com.example.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class Configuration {
private int minimum,maximum;

public Configuration() {
	System.out.println("Configuration.Configuration()");
}

public Configuration(int minimum, int maximum) {
	this.minimum = minimum;
	this.maximum = maximum;
}

public void setMinimum(int minimum) {
	this.minimum = minimum;
}

public void setMaximum(int maximum) {
	this.maximum = maximum;
}

public int getMinimum() {
	return minimum;
}

public int getMaximum() {
	return maximum;
}

}
