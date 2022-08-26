package ru.geekbrains.patterns.proxy;

public class LabDoor implements Door{
    @Override
    public void open() {
        System.out.println("Open Door");
    }

    @Override
    public void close() {
        System.out.println("Close Door");
    }
}
