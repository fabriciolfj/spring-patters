package com.github.fabriciolfj.patters.bridge;

import org.springframework.stereotype.Component;

@Component("emailChannel")
public class EmailChannel implements NotificationChannel {

    @Override
    public void send(String destination, String message) {
        System.out.println("E-mail para " + destination + ": " + message);
    }
}
