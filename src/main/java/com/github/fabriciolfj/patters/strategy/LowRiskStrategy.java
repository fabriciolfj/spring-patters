package com.github.fabriciolfj.patters.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("lowRisk")
public class LowRiskStrategy implements InterestRateStrategy {

    @Override
    public BigDecimal calculate(BigDecimal amount, int months) {
        return amount.multiply(BigDecimal.valueOf(0.012 * months));
    }
}