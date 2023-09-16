package com.enoca.challenge.controller.employee.api;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all")
    public DataResult<List<Employee>> findAll(){
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Employee> findById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @PostMapping(value = "/save")
    public DataResult<Employee> save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping(value = "/{id}")
    public DataResult<String> deleteById(@PathVariable Integer id){
        return employeeService.deleteById(id);
    }
}
