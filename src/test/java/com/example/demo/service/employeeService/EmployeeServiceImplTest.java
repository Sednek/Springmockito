package com.example.demo.service.employeeService;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    Employee expected = new Employee("Nikita", 1, 10000);

    EmployeeService emps = new EmployeeServiceImpl();

    @Test
    void shouldAddAndReturnEmployeeWhenAddEmployee() {
        expected.resetEmployeeID();
        Employee actual = emps.addEmployee(expected);
        assertEquals(expected, actual);

    }

    @Test
    void shouldThrowExceptionWhenAddNullEmployee() {
        expected.resetEmployeeID();
        assertThrows(IllegalArgumentException.class, () -> emps.addEmployee(null), "Передан пустой сотрудник");
    }

    @Test
    void shouldFireEmployeeWhenFireEmployee(){
        expected.resetEmployeeID();

        emps.addEmployee("Nikita Demin", 1,10000);
        emps.addEmployee("Nikita Ivanov", 1, 20000);

        emps.fireEmployee("Nikita Demin", 1,10000);

        expected.resetEmployeeID();

        EmployeeService emps2 = new EmployeeServiceImpl();

        emps2.addEmployee("Nikita Ivanov", 1, 20000);
        emps2.getEmployees().get(0).setId(2);

        assertEquals(emps.getEmployees(), emps2.getEmployees());
    }

    @Test
    void getEmployees(){
        expected.resetEmployeeID();

        emps.addEmployee("Nikita Demin", 1,10000);
        emps.addEmployee("Nikita Ivanov", 1, 20000);

        expected.resetEmployeeID();

        EmployeeService emps2 = new EmployeeServiceImpl();
        emps2.addEmployee("Nikita Demin", 1,10000);
        emps2.addEmployee("Nikita Ivanov", 1, 20000);

        assertEquals(emps.getEmployees(),emps2.getEmployees());
    }
}
