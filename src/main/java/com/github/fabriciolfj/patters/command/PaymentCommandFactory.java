package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentCommandFactory {

    private final InMemoryPaymentRepository repository;

    public PaymentCommand create(String customerId, BigDecimal amount) {
        Payment payment = new Payment(
                UUID.randomUUID().toString(), customerId, amount, PaymentStatus.COMPLETED);

        return new CreatePaymentCommand(repository, payment);
    }

    public PaymentCommand cancel(String paymentId) {
        Payment payment = repository.findById(paymentId)
                .orElseThrow(() -> new NoSuchElementException("Pagamento não encontrado: " + paymentId));

        return new CancelPaymentCommand(repository, payment);
    }
}