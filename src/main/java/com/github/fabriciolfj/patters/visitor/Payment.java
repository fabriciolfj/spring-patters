package com.github.fabriciolfj.patters.visitor;

public interface Payment {

    void accept(PaymentVisitor paymentVisitor);
}
