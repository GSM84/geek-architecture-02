package ru.geekbrains.patterns.bahavior.iterator;

public class Main {
    public static void main(String[] args) {
        IterImpl IterImpl = new IterImpl(11);

        for (Integer dig:IterImpl) {
            System.out.println(dig);
        }
    }
}
