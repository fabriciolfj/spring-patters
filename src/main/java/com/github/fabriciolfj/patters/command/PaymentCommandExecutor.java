package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentCommandExecutor {

    private final JdbcPaymentRepository paymentRepository;
    private final PaymentUndoRepository undoRepository;

    public PaymentExecution run(PaymentCommand command, String idPayment) {
        log.info("Executando: {}", command.getClass().getSimpleName());

        PaymentExecution execution = command.execute();
        undoRepository.save(idPayment, execution.undoStatus());

        return execution;
    }

    public void undo(String paymentId) {
        var undoStatus = undoRepository.findByPaymentId(paymentId);
        if (undoStatus.isEmpty()) {
            log.info("Nenhuma ação para desfazer no pagamento: {}", paymentId);
            return;
        }
        log.info("Desfazendo pagamento: {}", paymentId);
        paymentRepository.findById(paymentId)
                .map(p -> p.withStatus(undoStatus.get()))
                .ifPresent(paymentRepository::save);
        undoRepository.delete(paymentId);
    }
}