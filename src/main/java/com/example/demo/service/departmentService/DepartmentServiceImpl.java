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

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {

        this.employeeService = employeeService;

    }

    public Employee findMaxSalaryByDepartment(int department) {
        Employee maxSalaryEmployee = employeeService.getEmployees().get(0);
        for (Employee employee : employeeService.getEmployees()) {
            if (employee.getDepartment() == department && maxSalaryEmployee.getSalary() < employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public Employee findMinSalaryByDepartment(int department) {
        Employee minSalaryEmployee = employeeService.getEmployees().get(0);
        for (Employee employee : employeeService.getEmployees()) {
            if (employee.getDepartment() == department && minSalaryEmployee.getSalary() > employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public List<Employee> printAllEmployeesInDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(emp -> emp.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> printEmployeesByDepartments() {
        Map<Integer, List<Employee>> empsByDep = new HashMap<>();
        List<Employee> emps = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (Employee employee : employeeService.getEmployees()) {
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
