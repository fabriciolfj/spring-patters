package com.github.fabriciolfj.patters.config;

import com.github.fabriciolfj.patters.service.EmailService;
import com.github.fabriciolfj.patters.service.LoggerService;
import com.github.fabriciolfj.patters.service.MetricService;
import com.github.fabriciolfj.patters.service.NotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DecoratorConfig {

    @Bean
    public NotifyService notifyService(@Qualifier("emailService") EmailService emailService) {
        LoggerService loggerService = new LoggerService(emailService);

        return new MetricService(loggerService);
    }
}
