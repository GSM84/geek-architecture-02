package ru.geekbrains.patterns.bridge.device;

public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    void status();

    void setMode(String mode);

}
