package com.github.fabriciolfj.patters.command;

public record CreatePaymentCommand(
        InMemoryPaymentRepository repository,
        Payment payment
) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        Payment saved = repository.save(payment);

        Runnable undo = () -> repository.findById(saved.id())
                .map(p -> p.withStatus(PaymentStatus.CANCELLED))
                .ifPresent(repository::save);

        return new PaymentExecution(saved, undo);
    }
}