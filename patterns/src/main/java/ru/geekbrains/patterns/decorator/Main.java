package ru.geekbrains.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        Coffee c2 = new MilkCoffee(c);


        System.out.println(c.getDescription());
        System.out.println(c2.getDescription());
    }
}
