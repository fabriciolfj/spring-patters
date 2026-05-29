package com.github.fabriciolfj.patters.composite;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ScoreRule implements ApprovalRule {

    @Override
    public boolean approve(BigDecimal amount, int mounths) {
        return amount.compareTo(BigDecimal.valueOf(80_000)) > 0;
    }

    @Override
    public String name() {
        return "ScoreRule";
    }
}
