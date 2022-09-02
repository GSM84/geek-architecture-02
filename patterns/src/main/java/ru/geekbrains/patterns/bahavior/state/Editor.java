package ru.geekbrains.patterns.bahavior.state;

public class Editor {
    private WritingState state;

    public Editor(WritingState state) {
        this.state = state;
    }

    public void setState(WritingState state){
        this.state = state;
    }

    void write(String word){
        this.state.write(word);
    }

}
