package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentCommandFactory factory;
    private final PaymentCommandExecutor executor;

    public Payment pay(String customerId, BigDecimal amount) {
        return executor.run(factory.create(customerId, amount));
    }

    public Payment cancel(String paymentId) {
        return executor.run(factory.cancel(paymentId));
    }

    public void undoLastAction() {
        executor.undoLast();
    }
}