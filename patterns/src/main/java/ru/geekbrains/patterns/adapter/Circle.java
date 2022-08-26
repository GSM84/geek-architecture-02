package ru.geekbrains.patterns.adapter;

public class Circle {
    private double radius;

    public Circle() {
    }

    public Circle(double radiues) {
        this.radius = radiues;
    }

    public double getRadius() {
        return radius;
    }


    public boolean isFits(Circle circle) {
        return this.radius >= circle.getRadius();
    }
}
