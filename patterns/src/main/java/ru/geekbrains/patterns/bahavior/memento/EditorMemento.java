package ru.geekbrains.patterns.bahavior.memento;

public class EditorMemento {
    private StringBuilder text;

    public EditorMemento(StringBuilder text) {
        this.text = new StringBuilder().append(text);
    }

    public StringBuilder getText() {
        return text;
    }
}
