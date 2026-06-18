package com.github.fabriciolfj.patters.command;

import java.math.BigDecimal;

public record Payment(String id, String customerId, BigDecimal amount, PaymentStatus status) {

    public Payment withStatus(PaymentStatus status) {
        return new Payment(id, customerId, amount, status);
    }
}