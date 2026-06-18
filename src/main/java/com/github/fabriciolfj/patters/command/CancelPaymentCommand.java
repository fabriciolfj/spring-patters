package com.github.fabriciolfj.patters.command;


public record CancelPaymentCommand(
        InMemoryPaymentRepository repository,
        Payment payment
) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        PaymentStatus previousStatus = payment.status(); // captura local, pro undo
        Payment cancelled = repository.save(payment.withStatus(PaymentStatus.CANCELLED));

        Runnable undo = () -> repository.findById(payment.id())
                .map(p -> p.withStatus(previousStatus))
                .ifPresent(repository::save);

        return new PaymentExecution(cancelled, undo);
    }
}