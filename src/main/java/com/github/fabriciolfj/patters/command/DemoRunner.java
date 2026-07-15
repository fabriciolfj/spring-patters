package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DemoRunner implements CommandLineRunner {

    private final PaymentService paymentService;
    private final JdbcPaymentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        demo();
    }

    public void demo() {
        Payment p1 = paymentService.pay("customer-1", BigDecimal.valueOf(150));
        Payment p2 = paymentService.pay("customer-2", BigDecimal.valueOf(300));
        Payment p3 = paymentService.pay("customer-3", BigDecimal.valueOf(500));

        System.out.println(repository.findAll()); // 3 COMPLETED

        paymentService.cancel(p1.id());
        paymentService.cancel(p2.id());

        System.out.println(repository.findAll()); // p1, p2 CANCELLED | p3 COMPLETED

        paymentService.undo(p2.id()); // desfaz só o p2, não importa a ordem
        System.out.println(repository.findAll()); // p1 CANCELLED | p2, p3 COMPLETED
    }
}
