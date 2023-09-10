package com.example.demo.service.departmentService;

import com.example.demo.models.Employee;
import com.example.demo.service.employeeService.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    List<Employee> employees;
    List<Employee> emptyList = new ArrayList<>();
    Map<Integer, List<Employee>> mapOfEmployees;


    Employee emp1 = new Employee("Nikita Demin", 1, 10000);
    Employee emp2 = new Employee("Sergey Sergeev", 1, 20000);
    Employee emp3 = new Employee("Ivan Ivanov", 1, 30000);

    @BeforeEach
    void setUp(){
        employees = List.of(emp1, emp2, emp3);
        mapOfEmployees = Map.of(1, employees, 2, emptyList, 3, emptyList, 4, emptyList, 5, emptyList);
    }


    @Test
    void findMaxSalaryByDepartmentTest_employeeFind_returnEmployeeWithMaxSalary() {
        when(employeeService.getEmployees()).thenReturn(employees);

        Employee res = departmentService.findMaxSalaryByDepartment(1);

        assertEquals(emp3, res);

    }

    @Test
    void findMinSalaryByDepartmentTest__employeeFind_returnEmployeeWithMinSalary() {
        when(employeeService.getEmployees()).thenReturn(employees);

        Employee res = departmentService.findMinSalaryByDepartment(1);

        assertEquals(emp1, res);
    }

    @Test
    void printEmployeesByDepartmentsTest_returnMapOfDepartmentsAndEmployeesInDeps() {
        when(employeeService.getEmployees()).thenReturn(employees);

        Map<Integer,List<Employee>> res = departmentService.printEmployeesByDepartments();

        assertEquals(mapOfEmployees, res);
    }
}