package ru.geekbrains.patterns.bahavior.state;

public class UpperCase implements WritingState {
    @Override
    public void write(String word) {
        System.out.println(word.toUpperCase());
    }
}
