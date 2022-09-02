package ru.geekbrains.patterns.bahavior.state;

public class Main {
    public static void main(String[] args) {
        Editor e = new Editor(new Default());

        e.write("Hello");
        e.setState(new LowerCase());
        e.write("Hello");
    }
}
