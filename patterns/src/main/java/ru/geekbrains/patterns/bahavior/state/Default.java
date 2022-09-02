package ru.geekbrains.patterns.bahavior.state;

public class Default implements WritingState {
    @Override
    public void write(String word) {
        System.out.println(word);
    }
}
