package ru.geekbrains.patterns.bahavior.memento;

public class Editor {
    private StringBuilder text;

    public Editor() {
        this.text = new StringBuilder();
    }

    public String getText() {
        return text.toString();
    }

    public void type(String text){
        this.text.append(text);
    }

    public EditorMemento save(){
        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento){
        this.text = memento.getText();
    }
}
