package com.github.fabriciolfj.patters.visitor;

public record CreditCardPayment(String cardNumber) implements Payment {

    @Override
    public void accept(PaymentVisitor paymentVisitor) {
        paymentVisitor.visitor(this);
    }
}
