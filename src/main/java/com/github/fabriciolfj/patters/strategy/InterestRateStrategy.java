package com.github.fabriciolfj.patters.strategy;

import java.math.BigDecimal;

public interface InterestRateStrategy {
    BigDecimal calculate(BigDecimal amount, int months);
}