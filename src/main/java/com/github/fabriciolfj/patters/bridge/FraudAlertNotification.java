package com.github.fabriciolfj.patters.bridge;

public class FraudAlertNotification extends Notification {

    public FraudAlertNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String destination) {
        channel.send(destination, "Atividade suspeita detectada na sua conta.");
    }
}