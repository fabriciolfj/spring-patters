package com.github.fabriciolfj.patters.visitor;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {

    private final TaxCalculatorImpl taxImpl;
    private final ReportPaymentImpl reportImpl;

    @Override
    public void run(String... args) throws Exception {
        var pix = new PixPayment("001", BigDecimal.valueOf(100));
        var card = new CreditCardPayment("1029921");

        var payments = List.of(pix, card);

        payments.forEach(p -> p.accept(taxImpl));

        payments.forEach(p -> p.accept(reportImpl));
    }
}
