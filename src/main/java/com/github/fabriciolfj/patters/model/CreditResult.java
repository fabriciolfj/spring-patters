package com.github.fabriciolfj.patters.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditResult {

    private String customerId;
    private BigDecimal amount;
    private int months;
    private CreditStatus status;

    public CreditResult approved() {
        this.status = CreditStatus.APPROVED;
        return this;
    }

    public CreditResult rejected() {
        this.status = CreditStatus.REJECTED;
        return this;
    }

}
