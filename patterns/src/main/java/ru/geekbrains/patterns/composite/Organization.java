package ru.geekbrains.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public int getTotalSalary(){
        int totalSalary = 0;

        for (Employee e:employees) {
            totalSalary += e.getSalary();
        }
        return  totalSalary;
    }
}
