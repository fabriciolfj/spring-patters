package com.github.fabriciolfj.patters.bridge;

import org.springframework.stereotype.Component;

@Component("smsChannel")
public class SmsChannel implements NotificationChannel {

    @Override
    public void send(String destination, String message) {
        System.out.println("SMS para " + destination + ": " + message);
    }
}