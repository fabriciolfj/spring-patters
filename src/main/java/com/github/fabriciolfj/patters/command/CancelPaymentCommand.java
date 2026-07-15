package com.github.fabriciolfj.patters.command;


public record CancelPaymentCommand(
        JdbcPaymentRepository repository,
        Payment payment
) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        PaymentStatus previousStatus = payment.status(); // captura local, pro undo
        Payment cancelled = repository.save(payment.withStatus(PaymentStatus.CANCELLED));

        return new PaymentExecution(cancelled, previousStatus);
    }
}