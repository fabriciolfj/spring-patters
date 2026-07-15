package com.github.fabriciolfj.patters.command;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentUndoRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(String paymentId, PaymentStatus undoStatus) {
        jdbcTemplate.update("""
                MERGE INTO payment_undo (payment_id, undo_status)
                KEY (payment_id)
                VALUES (?, ?)
                """,
                paymentId, undoStatus.name());
    }

    public Optional<PaymentStatus> findByPaymentId(String paymentId) {
        List<PaymentStatus> result = jdbcTemplate.query(
                "SELECT undo_status FROM payment_undo WHERE payment_id = ?",
                (rs, rowNum) -> PaymentStatus.valueOf(rs.getString("undo_status")),
                paymentId);
        return result.stream().findFirst();
    }

    public void delete(String paymentId) {
        jdbcTemplate.update("DELETE FROM payment_undo WHERE payment_id = ?", paymentId);
    }
}