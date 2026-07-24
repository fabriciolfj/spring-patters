package com.github.fabriciolfj.patters.commandv2;

import java.math.BigDecimal;

public record Payment(String id, String status, BigDecimal value) { }
