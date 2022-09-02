package ru.geekbrains.patterns.bahavior.chain;

public class PayPal extends Account {
    public PayPal(double balance, String name, Account next) {
        super(balance, name, next);
    }
}
