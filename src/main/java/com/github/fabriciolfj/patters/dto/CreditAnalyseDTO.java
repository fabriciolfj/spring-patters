package com.github.fabriciolfj.patters.dto;

import java.math.BigDecimal;

public record CreditAnalyseDTO(String customerId, BigDecimal amount, int months) {
}
