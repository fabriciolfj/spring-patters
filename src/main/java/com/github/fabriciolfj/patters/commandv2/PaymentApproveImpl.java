package com.github.fabriciolfj.patters.commandv2;

import static com.github.fabriciolfj.patters.commandv2.PaymentRepository.PAYMENTS_REPO;

public record PaymentApproveImpl(Payment payment) implements PaymentCommand {

    @Override
    public PaymentExecution execute() {
        PAYMENTS_REPO.put(payment.id(), payment);

        var paymentNew = new Payment(payment().id(), "CANCEL", payment().value());
        return new PaymentExecution(payment, paymentNew);
    }
}
