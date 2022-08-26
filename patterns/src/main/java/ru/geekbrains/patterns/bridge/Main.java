package ru.geekbrains.patterns.bridge;

import ru.geekbrains.patterns.bridge.controls.ExtendedControl;
import ru.geekbrains.patterns.bridge.controls.StandardControl;
import ru.geekbrains.patterns.bridge.device.Device;
import ru.geekbrains.patterns.bridge.device.Owen;
import ru.geekbrains.patterns.bridge.device.WashingMachine;

public class Main {
    public static void main(String[] args) {
        testDevice(new Owen());
        testDevice(new WashingMachine());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with standard control.");
        StandardControl stc = new StandardControl(device);
        stc.power();
        stc.setMode("Heating");
        device.status();

        System.out.println("Tests with advanced control.");
        ExtendedControl ect = new ExtendedControl(device);
        ect.pause();
        device.status();
    }

}
