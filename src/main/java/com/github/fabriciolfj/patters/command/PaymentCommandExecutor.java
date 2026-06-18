package com.github.fabriciolfj.patters.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

@Component
@Slf4j
public class PaymentCommandExecutor {

    private final Deque<Runnable> undoHistory = new ArrayDeque<>();

    public Payment run(final PaymentCommand command) {
        log.info("execute: {}", command.getClass().getSimpleName());

        final var execution = command.execute();
        undoHistory.push(execution.undo());

        return execution.payment();
    }

    public void undoLast() {
        if (undoHistory.isEmpty()) {
            log.info("nothing");
            return;
        }

        undoHistory.pop().run();
    }
}
