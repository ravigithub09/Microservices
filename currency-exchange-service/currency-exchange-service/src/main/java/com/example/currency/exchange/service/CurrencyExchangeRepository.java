package com.example.currency.exchange.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
public ExchangeValue findByFromAndTo(String from,String to);
}
