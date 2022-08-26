package ru.geekbrains.patterns.decorator;

public class MilkCoffee implements Coffee {
    private Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return this.coffee.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", Milk";
    }
}
