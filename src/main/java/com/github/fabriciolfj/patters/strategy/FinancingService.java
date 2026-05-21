package com.github.fabriciolfj.patters.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FinancingService {

    private final Map<String, InterestRateStrategy> strategies;

    public BigDecimal calculate(String risk, BigDecimal amount, int months) {
        return strategies.get(risk).calculate(amount, months); // troca em runtime
    }
}