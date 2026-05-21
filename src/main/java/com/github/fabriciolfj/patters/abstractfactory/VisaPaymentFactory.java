package com.github.fabriciolfj.patters.abstractfactory;

import org.springframework.stereotype.Component;

@Component("visa")
public class VisaPaymentFactory implements PaymentFactory {

    @Override
    public PaymentValidator createValidator() { return new VisaValidator(); }

    @Override
    public PaymentProcessor createProcessor() { return new VisaProcessor(); }
}
