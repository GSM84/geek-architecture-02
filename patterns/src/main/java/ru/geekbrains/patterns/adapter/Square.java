package ru.geekbrains.patterns.adapter;

public class Square {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSqueare(){
        return Math.pow(this.width, 2);
    }
}
