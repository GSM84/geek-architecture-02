package ru.geekbrains.patterns.bahavior.state;

public class LowerCase implements WritingState{
    @Override
    public void write(String word) {
        System.out.println(word.toLowerCase());
    }
}
