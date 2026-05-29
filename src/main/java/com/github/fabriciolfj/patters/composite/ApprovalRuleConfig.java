package com.github.fabriciolfj.patters.composite;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApprovalRuleConfig {

    @Bean
    public ApprovalRule pfRules(ScoreRule scoreRule, IncomeRule incomeRule) {
        return new CompositeApprovalRule("PF-Rules", List.of(scoreRule, incomeRule));
    }

    @Bean
    public ApprovalRule pjRules(DebtRatioRule rule, IncomeRule incomeRule) {
        return new CompositeApprovalRule("PJ-Rules", List.of(rule, incomeRule));
    }

    //composite de composites
    @Bean
    public ApprovalRule fullApprovalRule(
            @Qualifier("pfRules") ApprovalRule pfRules,
            @Qualifier("pjRules") ApprovalRule pjRules) {
        return new CompositeApprovalRule("Full-Approval-Rule", List.of(pfRules, pjRules));
    }
}
