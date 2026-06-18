package com.github.fabriciolfj.patters.command;

public record PaymentExecution(Payment payment, Runnable undo) {}