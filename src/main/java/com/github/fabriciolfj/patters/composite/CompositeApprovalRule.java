package com.github.fabriciolfj.patters.composite;

import java.math.BigDecimal;
import java.util.List;

public class CompositeApprovalRule implements ApprovalRule {

    private final String name;
    private final List<ApprovalRule> rules;

    public CompositeApprovalRule(String name, List<ApprovalRule> rules) {
        this.name = name;
        this.rules = rules;
    }

    @Override
    public boolean approve(BigDecimal amount, int mounths) {
        return rules.stream().allMatch(rule -> rule.approve(amount, mounths));
    }

    @Override
    public String name() {
        return name;
    }
}
