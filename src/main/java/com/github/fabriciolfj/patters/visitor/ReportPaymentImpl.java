package com.github.fabriciolfj.patters.visitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportPaymentImpl implements PaymentVisitor {

    @Override
    public void visitor(PixPayment pix) {
        log.info("report pix");
    }

    @Override
    public void visitor(CreditCardPayment card) {
        log.info("report card");
    }
}
