package ru.geekbrains.patterns.composite;

public class Designer implements Employee {
    private String name;
    private int salary;

    public Designer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setSalary(int salary) {
        this.salary= salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
