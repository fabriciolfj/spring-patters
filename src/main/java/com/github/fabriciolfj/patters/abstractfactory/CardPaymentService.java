package com.github.fabriciolfj.patters.abstractfactory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CardPaymentService {

    private final Map<String, PaymentFactory> factories;

    public void pay(String brand, String cardNumber, BigDecimal amount) {
        PaymentFactory factory = factories.get(brand);
        factory.createValidator().validate(cardNumber);  // objetos da mesma família
        factory.createProcessor().process(amount);
    }
}