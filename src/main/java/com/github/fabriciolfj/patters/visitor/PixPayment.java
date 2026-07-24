package com.github.fabriciolfj.patters.visitor;

import java.math.BigDecimal;

public record PixPayment(String key, BigDecimal amount) implements Payment {

    @Override
    public void accept(PaymentVisitor visitor) {
        visitor.visitor(this);
    }
}
