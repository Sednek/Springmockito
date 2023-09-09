package com.example.demo.service.departmentService;

import com.example.demo.models.Employee;
import com.example.demo.service.employeeService.EmployeeService;
import com.example.demo.service.employeeService.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService = new EmployeeServiceImpl();

    private final DepartmentService departmentService = new DepartmentServiceImpl(employeeService);;

    @BeforeEach
    public void setUp(){
        employeeService.addEmployee("Nikita Demin", 1, 10000);
        employeeService.addEmployee("Sergey Sergeev", 1, 20000);
        employeeService.addEmployee("Ivan Ivanov", 1, 30000);
    }

    @Test
    void findMaxSalaryByDepartmentTest() {
        System.out.println(departmentService.printEmployeesByDepartments());
    }

    @Test
    void findMinSalaryByDepartmentTest() {
    }

    @Test
    void printEmployeesByDepartmentsTest() {
    }
}