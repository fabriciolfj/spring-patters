package com.github.fabriciolfj.patters.substitutovisitor;

public final class CredicardPayment extends Payment {

    @Override
    public void execute() {
        IO.println("card payment");
    }
}
