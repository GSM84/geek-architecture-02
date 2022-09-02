package ru.geekbrains.patterns.bahavior.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
