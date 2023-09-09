package com.example.demo.contoller;

import com.example.demo.models.Employee;
import com.example.demo.service.departmentService.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getEmployeesInDepartment(@PathVariable int id){
        return departmentService.printAllEmployeesInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee getMaxSalaryEmployeeByDepartment(@PathVariable int id){
        return departmentService.findMaxSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee getMinSalaryEmployeeByDepartment(@PathVariable int id){
        return departmentService.findMinSalaryByDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getAllEmployees(){
        return departmentService.printEmployeesByDepartments();
    }

}
