package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DemoRunner implements CommandLineRunner {

    private final PaymentService paymentService;
    private final InMemoryPaymentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        demo();
    }

    public void demo() {
        Payment p1 = paymentService.pay("customer-1", BigDecimal.valueOf(150));
        System.out.println(repository.findAll()); // [Payment[id=..., status=COMPLETED]]

        paymentService.cancel(p1.id());
        System.out.println(repository.findAll()); // [Payment[id=..., status=CANCELLED]]

        paymentService.undoLastAction(); // desfaz o cancelamento
        System.out.println(repository.findAll()); // [Payment[id=..., status=COMPLETED]]
    }
}
