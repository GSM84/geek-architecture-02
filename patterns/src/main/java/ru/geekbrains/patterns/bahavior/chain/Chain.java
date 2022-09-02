package ru.geekbrains.patterns.bahavior.chain;

public class Chain {
    public static void main(String[] args) {
        Account bitCoin = new BitCoin(300d, "BitCoin", null);
        Account payPal = new PayPal(200d, "PayPal", bitCoin);
        Account bank = new BankAccount(100d, "BankAccount", payPal);

        bank.pay(17);
    }
}
