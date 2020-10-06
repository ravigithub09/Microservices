package com.example.microsevices.conversion.service;

import java.math.BigDecimal;

public class CurrncyConversionBean {

	private long id;
	private String from;
	private String to;
	private BigDecimal exchange;
	private BigDecimal quantity;
	private BigDecimal totalCalAmt;
	private int port;
	public CurrncyConversionBean() {
		System.out.println("CurrncyConversionBean.CurrncyConversionBean()");
	}
	public CurrncyConversionBean(long id, String from, String to, BigDecimal exchange, BigDecimal quantity,
			BigDecimal totalCalAmt, int port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchange = exchange;
		this.quantity = quantity;
		this.totalCalAmt = totalCalAmt;
		this.port = port;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public BigDecimal getTotalCalAmt() {
		return totalCalAmt;
	}
	public int getPort() {
		return port;
	}
	
	
	
	
}
