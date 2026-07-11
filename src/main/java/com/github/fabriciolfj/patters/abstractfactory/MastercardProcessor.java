package com.github.fabriciolfj.patters.abstractfactory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MastercardProcessor implements PaymentProcessor {

    @Override
    public void process(BigDecimal amount) {

    }
}
