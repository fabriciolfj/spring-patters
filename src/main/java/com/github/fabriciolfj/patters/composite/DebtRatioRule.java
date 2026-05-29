package com.github.fabriciolfj.patters.composite;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DebtRatioRule implements ApprovalRule {

    @Override
    public boolean approve(BigDecimal amount, int mounths) {
        return amount.compareTo(BigDecimal.valueOf(200_000)) <= 0;
    }

    @Override
    public String name() {
        return "DebtRatioRule";
    }
}
