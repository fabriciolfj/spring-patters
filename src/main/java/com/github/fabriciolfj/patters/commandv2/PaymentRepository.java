package com.github.fabriciolfj.patters.commandv2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentRepository {

    public static final Map<String, Payment> PAYMENTS_REPO = new ConcurrentHashMap<>();
    public static final Map<String, Payment> PAYMENTS_REPO_UNDO = new ConcurrentHashMap<>();
}
