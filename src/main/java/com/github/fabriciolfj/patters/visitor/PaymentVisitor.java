package com.github.fabriciolfj.patters.visitor;

public interface PaymentVisitor {

    void visitor(PixPayment pix);
    void visitor(CreditCardPayment card);
}
