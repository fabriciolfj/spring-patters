package com.github.fabriciolfj.patters.abstractfactory;

import java.math.BigDecimal;

public interface PaymentProcessor {

    void process(BigDecimal amount);
}