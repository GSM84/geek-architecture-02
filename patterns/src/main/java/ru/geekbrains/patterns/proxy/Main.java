package ru.geekbrains.patterns.proxy;

public class Main {
    public static void main(String[] args) {
        SecuredDoor secDoor = new SecuredDoor(new LabDoor());

        secDoor.open("secret");


    }
}
