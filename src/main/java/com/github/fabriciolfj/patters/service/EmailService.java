package com.github.fabriciolfj.patters.service;

import com.github.fabriciolfj.patters.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("emailService")
public class EmailService implements NotifyService{

    @Override
    public void execute(Person person) {
        log.info("send email to person {}, successfully", person);
    }
}
