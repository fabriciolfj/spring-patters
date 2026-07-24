package com.github.fabriciolfj.patters.substitutovisitor;

public sealed abstract class Payment permits CredicardPayment, PixPayment {

    public abstract void execute();
}
