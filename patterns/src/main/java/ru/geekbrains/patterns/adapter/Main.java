package ru.geekbrains.patterns.adapter;

public class Main {
    public static void main(String[] args) {
        Square sq = new Square(5);

        SquareAdapter ad = new SquareAdapter(sq);

        System.out.println("Радиус описанной окружности " + ad.getRadius());
    }
}
