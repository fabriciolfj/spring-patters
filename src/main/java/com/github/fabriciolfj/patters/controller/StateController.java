package com.github.fabriciolfj.patters.controller;

import com.github.fabriciolfj.patters.state.OrchestratorOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/state")
public class StateController {

    private final OrchestratorOrder orchestratorOrder;

    @GetMapping
    public void executeState() {
        orchestratorOrder.process();
    }
}
