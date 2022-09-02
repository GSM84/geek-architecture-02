package ru.geekbrains.patterns.bahavior.chain;

public abstract class Account {

    private double balance;

    private String name;

    private Account next;

    public Account(double balance, String name, Account next) {
        this.balance = balance;
        this.name = name;
        this.next = next;
    }

    public void pay(double amount){
        if (canPay(amount)) {
            System.out.println("Paid using " + this.name);
        } else if (next != null) {
            System.out.println("Can't pay using " + this.name);
            next.pay(amount);
        } else {
            throw  new RuntimeException("Not enough founds at any account.");
        }
    }

    private boolean canPay(double amount){
        return this.balance >= amount;
    }
}
