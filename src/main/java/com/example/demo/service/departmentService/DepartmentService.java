package com.example.demo.service.departmentService;

import com.example.demo.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> printAllEmployeesInDepartment(int department);

    double calculateAllMonthSalariesByDepartment(int department);

    Employee findMaxSalaryByDepartment(int department);

    Employee findMinSalaryByDepartment(int department);

    Map<Integer, List<Employee>> printEmployeesByDepartments();

}
