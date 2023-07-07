package com.example.demo.service;

import com.example.demo.models.Employee;

import java.util.List;

public interface DepartmentService {
    List<Employee> printAllEmployeesInDepartment(int department);

    double calculateAllMonthSalariesByDepartment(int department, Employee[] employees);

    Employee findMaxSalaryByDepartment(int department, Employee[] employees);

    Employee findMinSalaryByDepartment(int department, Employee[] employees);

    void printEmployeesByDepartments();

    void fireEmployeeByDepartmentAndId(int id, int department);

    void addEmployee(String name, int department, double salary);

}
