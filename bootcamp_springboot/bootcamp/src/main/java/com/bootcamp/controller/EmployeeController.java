package com.bootcamp.controller;

import com.bootcamp.UserNotFoundException;
import com.bootcamp.entity.Employee;
import com.bootcamp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Employee e=service.getEmployeeById(id);
        if(e==null) throw new UserNotFoundException("id:" +id);
        else return e;
    }

    // POST - Create Employee
    @PostMapping
    public Employee createEmployee(@Valid  @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    // PUT - Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmp) {
        return service.updateEmployee(id, newEmp);
    }

    // DELETE - Remove Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}

