package com.github.fabriciolfj.patters.command;

public record CreatePaymentCommand(
        JdbcPaymentRepository repository,
        Payment payment
) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        Payment saved = repository.save(payment);

        return new PaymentExecution(saved, PaymentStatus.CANCELLED);
    }
}