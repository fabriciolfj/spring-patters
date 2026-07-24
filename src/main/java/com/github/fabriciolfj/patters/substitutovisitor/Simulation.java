package com.github.fabriciolfj.patters.substitutovisitor;

public class Simulation {

    static void main() {
        var pix = new PixPayment();

        execute(pix);
    }

    static void execute(Payment payment) {
        switch (payment) {
            case PixPayment p -> p.execute();
            case CredicardPayment c -> c.execute();
        }
    }
}
