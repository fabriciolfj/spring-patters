package com.github.fabriciolfj.patters.abstractfactory;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//familia mastercard
@Component("mastercard")
@RequiredArgsConstructor
public class MastercardPaymentFactory implements PaymentFactory {

    private final MastercardProcessor mastercardProcessor;
    private final MastercardValidator mastercardValidator;

    @Override
    public PaymentValidator createValidator() { return mastercardValidator; }

    @Override
    public PaymentProcessor createProcessor() { return mastercardProcessor; }
}