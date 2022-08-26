package ru.geekbrains.patterns.bridge.controls;

import ru.geekbrains.patterns.bridge.device.Device;

public class StandardControl implements Controls{
    private Device dev;

    public StandardControl(Device dev) {
        this.dev = dev;
    }

    @Override
    public void power() {
        if (dev.isEnabled()) {
            dev.disable();
        } else {
            dev.enable();
        }
    }

    @Override
    public void setMode(String mode) {
        dev.setMode(mode);
    }

    @Override
    public void test() {
        dev.status();
    }
}
