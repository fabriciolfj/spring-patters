package com.github.fabriciolfj.patters.commandv2;

import static com.github.fabriciolfj.patters.commandv2.PaymentRepository.PAYMENTS_REPO;

public record PaymentCancelmpl(String id) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        var payment = PAYMENTS_REPO.get(id);
        if (payment == null) {
            throw new RuntimeException();
        }

        var paymentCancel = new Payment(payment.id(), "CANCEL", payment.value());
        return new PaymentExecution(paymentCancel, payment);
    }
}
