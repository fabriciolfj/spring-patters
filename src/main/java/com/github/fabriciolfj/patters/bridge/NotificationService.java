package com.github.fabriciolfj.patters.bridge;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Qualifier("paymentEmailNotification")
    private final Notification paymentNotification;

    @Qualifier("fraudSmsNotification")
    private final Notification fraudNotification;

    public void onPaymentConfirmed(String email) {
        paymentNotification.notifyUser(email);
    }

    public void onFraudDetected(String phone) {
        fraudNotification.notifyUser(phone);
    }
}