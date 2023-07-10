package com.example.demo.service.departmentService;

import com.example.demo.models.Employee;
import com.example.demo.service.employeeService.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Employee> employees;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employees = employeeService.getEmployees();
    }

    public List<Employee> printAllEmployeesInDepartment(int department) {
        return employees.stream()
                .filter(emp -> emp.getDepartment() == department)
                .toList();
    }
    public double calculateAllMonthSalariesByDepartment(int department) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && maxSalaryEmployee.getSalary() < employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public Employee findMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && minSalaryEmployee.getSalary() > employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Map<Integer, List<Employee>> printEmployeesByDepartments() {
        Map<Integer, List<Employee>> empsByDep = new HashMap<>();
        List<Employee> emps = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == i) {
                    emps.add(employee);
                }
            }
            empsByDep.put(i, List.copyOf(emps));
            emps.clear();
        }
        return empsByDep;
    }


}
