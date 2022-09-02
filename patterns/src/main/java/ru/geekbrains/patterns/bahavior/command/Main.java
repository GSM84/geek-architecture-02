package ru.geekbrains.patterns.bahavior.command;

public class Main {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        Command on = new TurnOn(bulb);
        Command off = new TurnOff(bulb);
        RC rc = new RC();

        rc.submit(on);
        rc.submit(off);

    }
}
