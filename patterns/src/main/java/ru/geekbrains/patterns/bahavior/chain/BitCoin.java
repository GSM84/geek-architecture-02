package ru.geekbrains.patterns.bahavior.chain;

public class BitCoin extends Account {

    public BitCoin(double balance, String name, Account next) {
        super(balance, name, next);
    }
}
