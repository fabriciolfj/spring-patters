package com.github.fabriciolfj.patters.service;

import com.github.fabriciolfj.patters.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MetricService implements NotifyService {

    private final NotifyService delegate;

    @Override
    public void execute(Person person) {
        log.info("metric service");

        delegate.execute(person);
    }
}
