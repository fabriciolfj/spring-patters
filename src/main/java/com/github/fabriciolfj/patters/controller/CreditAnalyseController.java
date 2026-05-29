package com.github.fabriciolfj.patters.controller;

import com.github.fabriciolfj.patters.composite.CreditAnalysisService;
import com.github.fabriciolfj.patters.dto.CreditAnalyseDTO;
import com.github.fabriciolfj.patters.model.CreditResult;
import com.github.fabriciolfj.patters.model.CreditStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit-analysis")
public class CreditAnalyseController {

    private final CreditAnalysisService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditResult create(@RequestBody CreditAnalyseDTO dto) {
        var model =  new CreditResult(dto.customerId(), dto.amount(), dto.months(), CreditStatus.PENDING);

        return service.execute(model);
    }
}
