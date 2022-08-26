package ru.geekbrains.patterns.bridge.device;

public class WashingMachine implements Device {
    private boolean status = false;
    private String mode;

    @Override
    public boolean isEnabled() {
        return status;
    }

    @Override
    public void enable() {
        this.status = true;
    }

    @Override
    public void disable() {
        this.status = false;
    }

    @Override
    public void status() {
        System.out.println("------------------------------------");
        System.out.println("| I'm WashingMachine.");
        System.out.println("| I'm " + (this.status?"On":"Off"));
        System.out.println("| Mode is " + mode);
        System.out.println("------------------------------------\n");
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }


}
