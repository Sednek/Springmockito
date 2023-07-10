package com.example.demo.models;

import java.util.Objects;

public class Employee {

    private static int employeeID = 1;

    private int id;
    private final String name;
    private int department;
    private double salary;

    public Employee(String name, int department, double salary) {
        this.id = employeeID++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void resetEmployeeID(){
        employeeID = 1;
        this.id = 1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format("{id: %d, Имя: %s, Департамент: %d, Зарплата: %.2f}", this.id, this.name, this.department, this.salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary);
    }
}