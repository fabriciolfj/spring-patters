package com.github.fabriciolfj.patters.bridge;

public interface NotificationChannel {

    void send(String destination, String message);
}