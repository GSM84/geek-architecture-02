package ru.geekbrains.patterns.facade;

public class Car {

    private FuelPipe fuelPipe;
    private Gear gear;
    private Engine engine;

    public Car() {
        this.fuelPipe = new FuelPipe();
        this.gear = new Gear();
        this.engine = new Engine();
    }

    public void drive() {
        fuelPipe.switchOn();
        fuelPipe.pumpFuel();
        engine.combustFuel();
        engine.startRotation();
        gear.passRotation();
    }
}
