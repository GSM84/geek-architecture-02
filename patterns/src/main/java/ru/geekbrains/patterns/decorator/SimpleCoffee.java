package ru.geekbrains.patterns.decorator;

public class SimpleCoffee implements  Coffee {
    private double cost = 2.5;
    private String descr = "Coffee";

    public SimpleCoffee() {
    }


    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return descr;
    }

}
