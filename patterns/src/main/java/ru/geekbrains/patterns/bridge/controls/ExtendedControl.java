package ru.geekbrains.patterns.bridge.controls;

import ru.geekbrains.patterns.bridge.device.Device;

public class ExtendedControl extends StandardControl {
    public ExtendedControl(Device dev) {
        super(dev);
    }

    public void pause(){
        System.out.println("Extended control set pause");
        this.setMode("Set pause");
    }
}
