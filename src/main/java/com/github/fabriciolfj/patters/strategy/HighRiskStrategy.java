package com.github.fabriciolfj.patters.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("highRisk")
public class HighRiskStrategy implements InterestRateStrategy {

    @Override
    public BigDecimal calculate(BigDecimal amount, int months) {
        return amount.multiply(BigDecimal.valueOf(0.035 * months));
    }
}