package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentCommandFactory factory;
    private final PaymentCommandExecutor executor;

    public Payment pay(String customerId, BigDecimal amount) {
        Payment payment = new Payment(
                UUID.randomUUID().toString(), customerId, amount, PaymentStatus.COMPLETED);

        PaymentCommand paymentCommand = factory.create(payment);
        return executor.run(paymentCommand, payment.id()).payment();
    }

    public Payment cancel(String paymentId) {
        PaymentCommand paymentCommand = factory.cancel(paymentId);
        return executor.run(paymentCommand, paymentId).payment();
    }

    public void undo(String paymentId) {
        executor.undo(paymentId);
    }
}