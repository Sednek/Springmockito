package com.example.demo.contoller;

import com.example.demo.service.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String printHello() {
        return "<b>Добро пожаловать в сервис по работе с сотрудниками";
    }

    @GetMapping(path = "/add-employee")
    public String addEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "department") int department, @RequestParam(value = "salary") int salary){
        employeeService.addEmployee(name, department, salary);
        return "employee add";
    }

    @GetMapping(path = "/max-salary")
    public String getEmployeeWithMaxSalaryByDepartment(@RequestParam(value = "departmentId") int departmentId){
        return employeeService.findMaxSalaryByDepartment(departmentId).toString();
    }

    @GetMapping(path = "/min-salary")
    public String getEmployeeWithMinSalaryByDepartment(@RequestParam(value = "departmentId") int departmentId){
        return employeeService.findMinSalaryByDepartment(departmentId).toString();
    }

    @GetMapping(value = "/all", params = "departmentId")
    public String getAllEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) int departmentId){
        return employeeService.printEmployeeByDepartments(departmentId).toString();
    }

    @GetMapping(path = "/all")
    public String getAllEmployees(){
        return employeeService.printEmployeesFromDepartments().toString();
    }

}
