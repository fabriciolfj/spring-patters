package com.github.fabriciolfj.patters.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryPaymentRepository {

    private final Map<String, Payment> payments = new ConcurrentHashMap<>();

    public Payment save(Payment payment) {
        payments.put(payment.id(), payment);
        return payment;
    }

    public Optional<Payment> findById(final String id) {
        return Optional.ofNullable(payments.get(id));
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }
}
