package com.github.fabriciolfj.patters.commandv2;

public record PaymentExecution(Payment payment, Payment undo) {
}
