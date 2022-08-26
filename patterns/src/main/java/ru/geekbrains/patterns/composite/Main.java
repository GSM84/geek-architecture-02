package ru.geekbrains.patterns.composite;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization();
        org.addEmployee(new Developer("dev1", 10000));
        org.addEmployee(new Developer("dev1", 7500));
        System.out.println(org.getTotalSalary());
    }
}
