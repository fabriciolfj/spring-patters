package com.github.fabriciolfj.patters.composite;

import com.github.fabriciolfj.patters.model.CreditResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditAnalysisService {

    private final ApprovalRule fullApprovalRule;

    public CreditResult execute(final CreditResult creditResult) {
        var result = fullApprovalRule.approve(creditResult.getAmount(), creditResult.getMonths());

        if (result) {
            return creditResult.approved();
        }

        return creditResult.rejected();
    }

}
