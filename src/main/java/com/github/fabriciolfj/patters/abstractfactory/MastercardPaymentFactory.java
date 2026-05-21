package com.github.fabriciolfj.patters.abstractfactory;


import org.springframework.stereotype.Component;

//familia mastercard
@Component("mastercard")
public class MastercardPaymentFactory implements PaymentFactory {

    @Override
    public PaymentValidator createValidator() { return new MastercardValidator(); }

    @Override
    public PaymentProcessor createProcessor() { return new MastercardProcessor(); }
}