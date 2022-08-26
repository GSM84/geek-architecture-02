package ru.geekbrains.patterns.adapter;

public class SquareAdapter extends Circle {

    private Square square;

    public SquareAdapter(Square square){
        this.square = square;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(square.getWidth() / 2, 2) * 2);
    }
}
