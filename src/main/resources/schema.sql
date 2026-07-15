CREATE TABLE IF NOT EXISTS payment (
    id VARCHAR(36) PRIMARY KEY,
    customer_id VARCHAR(100) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS payment_undo (
    payment_id VARCHAR(36) PRIMARY KEY,
    undo_status VARCHAR(20) NOT NULL
);
