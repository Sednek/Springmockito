package com.example.demo.models;

public class Employee {

    private static int employeeID = 1;

    private int id;
    private String name;
    private int department;
    private double salary;

    public Employee(String name, int department, double salary) {
        this.id = employeeID++;
        this.name = name;
        this.department = department;
        this.salary = salary;
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
        return String.format("id: %d, Имя: %s, Департамент: %d, Зарплата: %.2f\n", this.id, this.name, this.department, this.salary);
    }
}