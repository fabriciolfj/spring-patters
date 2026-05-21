package com.github.fabriciolfj.patters.abstractfactory;

public interface PaymentFactory {

    PaymentValidator createValidator();

    PaymentProcessor createProcessor();
}