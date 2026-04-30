package com.github.fabriciolfj.patters.service;

import com.github.fabriciolfj.patters.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class LoggerService implements NotifyService {

    private final EmailService delegate;

    @Override
    public void execute(Person person) {
        log.info("service log");

        delegate.execute(person);
    }
}
