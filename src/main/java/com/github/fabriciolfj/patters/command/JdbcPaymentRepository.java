package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JdbcPaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Payment> ROW_MAPPER = (rs, rowNum) -> new Payment(
            rs.getString("id"),
            rs.getString("customer_id"),
            rs.getBigDecimal("amount"),
            PaymentStatus.valueOf(rs.getString("status"))
    );

    public Payment save(Payment payment) {
        jdbcTemplate.update("""
                MERGE INTO payment (id, customer_id, amount, status)
                KEY (id)
                VALUES (?, ?, ?, ?)
                """,
                payment.id(), payment.customerId(), payment.amount(), payment.status().name());
        return payment;
    }

    public Optional<Payment> findById(String id) {
        List<Payment> result = jdbcTemplate.query(
                "SELECT id, customer_id, amount, status FROM payment WHERE id = ?",
                ROW_MAPPER, id);
        return result.stream().findFirst();
    }

    public List<Payment> findAll() {
        return jdbcTemplate.query(
                "SELECT id, customer_id, amount, status FROM payment", ROW_MAPPER);
    }
}