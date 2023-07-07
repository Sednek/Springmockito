package com.example.demo.service;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Employee> employees;

    public DepartmentServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(String name, int department, double salary) {
        Employee emp = new Employee(name, department, salary);
        employees.add(emp);
    }

    public void fireEmployeeByDepartmentAndId(int id, int department) {
        employees.removeIf(employee -> employee.getId() == id && employee.getDepartment() == department);
    }

    public List<Employee> printAllEmployeesInDepartment(int department) {
        List<Employee> emp = employees.///////////////////////////
    }

    public double calculateAllMonthSalariesByDepartment(int department, Employee[] employees) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findMaxSalaryByDepartment(int department, Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && maxSalaryEmployee.getSalary() < employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public Employee findMinSalaryByDepartment(int department, Employee[] employees) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && minSalaryEmployee.getSalary() > employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public void printEmployeesByDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел №" + i);
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == i) {
                    System.out.printf("id: %d, Имя: %s, Зарплата: %.2f\n", employee.getId(), employee.getName(), employee.getSalary());
                }
            }
        }
    }


}
