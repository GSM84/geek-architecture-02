package ru.geekbrains.patterns.bahavior.memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("some message.");
        editor.type("Another msg.");

        EditorMemento saved = editor.save();

        editor.type("third msg.");
        System.out.println(editor.getText());

        editor.restore(saved);

        System.out.println(editor.getText());
    }
}
