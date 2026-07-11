package com.github.fabriciolfj.patters.abstractfactory;

import org.springframework.stereotype.Component;

@Component
public class MastercardValidator implements PaymentValidator{

    @Override
    public void validate(String cardNumber) {

    }
}
