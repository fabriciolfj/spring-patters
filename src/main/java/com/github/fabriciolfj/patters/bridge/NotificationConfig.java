package com.github.fabriciolfj.patters.bridge;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public Notification paymentEmailNotification(
            @Qualifier("emailChannel") NotificationChannel channel) {
        return new PaymentNotification(channel);
    }

    @Bean
    public Notification fraudSmsNotification(
            @Qualifier("smsChannel") NotificationChannel channel) {
        return new FraudAlertNotification(channel);
    }
}
