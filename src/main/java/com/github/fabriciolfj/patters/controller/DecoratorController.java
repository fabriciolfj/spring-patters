package com.github.fabriciolfj.patters.controller;

import com.github.fabriciolfj.patters.model.Person;
import com.github.fabriciolfj.patters.service.NotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/decorator")
public class DecoratorController {

    private final NotifyService notifyService;

    @PostMapping
    public void send() {
        var person = new Person("eu");

        notifyService.execute(person);
    }
}
