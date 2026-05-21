package com.github.fabriciolfj.patters.bridge;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Notification {

    protected final NotificationChannel channel; // <- a ponte

    public abstract void notifyUser(String destination);
}