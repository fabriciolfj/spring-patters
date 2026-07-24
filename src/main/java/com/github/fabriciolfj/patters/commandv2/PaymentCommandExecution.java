package com.github.fabriciolfj.patters.commandv2;



import static com.github.fabriciolfj.patters.commandv2.PaymentRepository.PAYMENTS_REPO;
import static com.github.fabriciolfj.patters.commandv2.PaymentRepository.PAYMENTS_REPO_UNDO;

public class PaymentCommandExecution {

    public void execution(PaymentCommand paymentCommand) {
        var command = paymentCommand.execute();

        PAYMENTS_REPO_UNDO.put(command.payment().id(), command.payment());
    }

    public void undo(String id) {
        var payment = PAYMENTS_REPO_UNDO.get(id);

        PAYMENTS_REPO.put(id, payment);
    }
}
