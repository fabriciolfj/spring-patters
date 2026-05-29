package com.github.fabriciolfj.patters.composite;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IncomeRule implements ApprovalRule {

    @Override
    public boolean approve(BigDecimal amount, int mounths) {
        return mounths <= 60;
    }

    @Override
    public String name() {
        return "IncomeRule";
    }
}
