package com.example.demo.service.employeeService;

import com.example.demo.models.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee findMaxSalaryByDepartment(int department);

    Employee findMinSalaryByDepartment(int department);

    double calculateAllMonthSalariesByDepartment(int department);

    List<Employee> printEmployeeByDepartments(int department);

    Map<Integer, List<Employee>> printEmployeesFromDepartments();

    Employee addEmployee(Employee employee);

    Employee addEmployee(String name, int department, int salary);

    List<Employee> getEmployees();
}

