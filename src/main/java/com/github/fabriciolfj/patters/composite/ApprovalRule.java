package com.github.fabriciolfj.patters.composite;

import java.math.BigDecimal;

public interface ApprovalRule {

    boolean approve(BigDecimal amount, int mounths);

    String name();
}
