package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class PaymentCommandFactory {

    private final JdbcPaymentRepository repository;

    public PaymentCommand create(Payment payment) {
        return new CreatePaymentCommand(repository, payment);
    }

    public PaymentCommand cancel(String paymentId) {
        Payment payment = repository.findById(paymentId)
                .orElseThrow(() -> new NoSuchElementException("Pagamento não encontrado: " + paymentId));

        return new CancelPaymentCommand(repository, payment);
    }
}