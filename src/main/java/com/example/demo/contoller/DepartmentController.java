package com.example.demo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/department")
public class DepartmentController {

    @GetMapping(path = "/{id}/employees")
    public String getEmployeesByDepartment(@PathVariable int id){

        return "ok";
    }


    @GetMapping(path = "/{id}/salary/sum")
    public String getSumSalaryByDepartment(@PathVariable int id){
        return "ok";
    }

    @GetMapping(path = "/{id}/salary/max")
    public String getMaxSalaryEmployeeByDepartment(@PathVariable int id){
        return "ok";
    }

    @GetMapping(path = "/{id}/salary/min")
    public String getMinSalaryEmployeeByDepartment(@PathVariable int id){
        return "ok";
    }

    @GetMapping(path = "/employees")
    public String getAllEmployees(@PathVariable int id){
        return "ok";
    }

}
