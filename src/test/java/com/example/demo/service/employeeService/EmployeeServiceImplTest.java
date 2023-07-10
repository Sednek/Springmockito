package com.example.demo.service.employeeService;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    Employee expected = new Employee("Nikita", 1, 10000);

    @Test
    void addEmployee() {
        EmployeeService emps = new EmployeeServiceImpl();
        expected.resetEmployeeID();
        Employee actual = emps.addEmployee(expected);
        assertEquals(expected, actual);

    }

    @Test
    void addEmployee2() {
        EmployeeService emps = new EmployeeServiceImpl();
        expected.resetEmployeeID();
        Employee actual = emps.addEmployee("Nikita", 1, 10000);
        assertEquals(expected, actual);

    }

    @Test
    void addEmployee3() {
        EmployeeService emps = new EmployeeServiceImpl();
        expected.resetEmployeeID();
        assertThrows(IllegalArgumentException.class, () -> emps.addEmployee(null), "Передан пустой сотрудник");
    }

    @Test
    void findMaxSalaryByDepartment() {
        EmployeeService emps = new EmployeeServiceImpl();
        expected.resetEmployeeID();
        emps.addEmployee("Nikita", 1, 1000);
        expected.resetEmployeeID();
        emps.addEmployee("Nikita", 1, 10000);
        assertEquals(expected, emps.findMaxSalaryByDepartment(1));
    }

    @Test
    void findMinSalaryByDepartment() {
        EmployeeService emps = new EmployeeServiceImpl();
        expected.resetEmployeeID();
        emps.addEmployee("Nikita", 1, 10000);
        expected.resetEmployeeID();
        emps.addEmployee("Nikita", 1, 1000);
        expected.setSalary(1000);
        assertEquals(expected, emps.findMinSalaryByDepartment(1));
    }

    @Test
    void calculateAllMonthSalariesByDepartment() {
        EmployeeService emps = new EmployeeServiceImpl();
        emps.addEmployee("Nikita", 1, 1000);
        emps.addEmployee("Oleg", 1, 1000);
        double actual = emps.calculateAllMonthSalariesByDepartment(1);
        double exp = 2000;
        assertEquals(exp, actual);
    }
}
