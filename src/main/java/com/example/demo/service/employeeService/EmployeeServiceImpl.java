package com.example.demo.service.employeeService;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        if(employee == null){
            throw new IllegalArgumentException("Передан пустой сотрудник");
        }
        employees.add(employee);
        return employee;
    }

    public Employee addEmployee(String name, int department, int salary){
        Employee e = new Employee(name, department, salary);
        employees.add(e);
        return e;
    }

    public void fireEmployee(String name, int department, int salary){
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getName().equals(name) && employees.get(i).getDepartment() == department && employees.get(i).getSalary() == salary){
                employees.remove(i);
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> printEmployeeByDepartments(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> printEmployeesFromDepartments() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
