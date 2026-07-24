package com.github.fabriciolfj.patters.substitutovisitor;

public final class PixPayment extends Payment {

    @Override
    public void execute() {
        IO.println("pix payment");
    }
}
