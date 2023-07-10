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

    private DepartmentService departmentService;

    @BeforeEach
    public void setUp(){
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    Employee emp = new Employee("Nikita", 1, 10000);

    @Test
    void calculateAllMonthSalariesByDepartmentTest() {

        Mockito.when(employeeService.addEmployee(any())).thenReturn(emp);
        Mockito.when(employeeService.addEmployee(any())).thenReturn(emp);


        employeeService.addEmployee("Nikita", 1, 10000);
        employeeService.addEmployee("Nikita", 1, 10000);

        assertEquals(20000d, departmentService.calculateAllMonthSalariesByDepartment(1));
        //org.opentest4j.AssertionFailedError:
        //Expected :20000.0
        //Actual   :0.0
    }

    @Test
    void findMaxSalaryByDepartmentTest() {
    }

    @Test
    void findMinSalaryByDepartmentTest() {
    }

    @Test
    void printEmployeesByDepartmentsTest() {
    }
}