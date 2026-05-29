package com.github.fabriciolfj.patters.bridge;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Notification paymentNotification;
    private final Notification fraudNotification;

    public NotificationService(
            @Qualifier("paymentEmailNotification") Notification paymentNotification,
            @Qualifier("fraudSmsNotification") Notification fraudNotification) {
        this.paymentNotification = paymentNotification;
        this.fraudNotification = fraudNotification;
    }

    public void onPaymentConfirmed(String email) {
        paymentNotification.notifyUser(email);
    }

    public void onFraudDetected(String phone) {
        fraudNotification.notifyUser(phone);
    }
}