package ru.geekbrains.patterns.bahavior.command;

public class TurnOn implements Command {

    private Bulb bulb;

    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        this.bulb.turnOn();
    }

    @Override
    public void undo() {
        this.bulb.turnOff();
    }

    @Override
    public void redo() {
        this.execute();
    }
}
