package com.github.fabriciolfj.patters.bridge;

public class PaymentNotification extends Notification {

    public PaymentNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String destination) {
        channel.send(destination, "Seu pagamento foi confirmado.");
    }
}