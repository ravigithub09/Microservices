package com.example.currency.exchange.service;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
@Id
private long id;
@Column(name = "exchange_from")
private String from;
@Column(name = "exchange_to")
private String to;
private BigDecimal exchange;
private int port;

public ExchangeValue() {
System.out.println("ExchangeValue.ExchangeValue()");
}

public ExchangeValue(long id, String from, String to, BigDecimal exchange) {
	this.id = id;
	this.from = from;
	this.to = to;
	this.exchange = exchange;
}

public long getId() {
	return id;
}

public String getFrom() {
	return from;
}

public String getTo() {
	return to;
}

public BigDecimal getExchange() {
	return exchange;
}

public int getPort() {
	return port;
}

public void setPort(int port) {
	this.port = port;
}


}
