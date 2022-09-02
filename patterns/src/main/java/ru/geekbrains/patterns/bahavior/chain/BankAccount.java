package ru.geekbrains.patterns.bahavior.chain;

public class BankAccount extends Account {

    public BankAccount(double balance, String name, Account next) {
        super(balance, name, next);
    }
}
