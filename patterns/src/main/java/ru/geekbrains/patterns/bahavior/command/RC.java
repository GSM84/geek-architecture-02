package ru.geekbrains.patterns.bahavior.command;

public class RC {
    public void submit(Command command) {
        command.execute();
    }
}
