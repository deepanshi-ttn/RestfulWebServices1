package com.bootcamp.service;

import com.bootcamp.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.Employee;
import com.bootcamp.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee newEmp) {
        Optional<Employee> emp = repository.findById(id);
        if (emp.isPresent()) {
            Employee updatedEmp = emp.get();
            updatedEmp.setName(newEmp.getName());
            updatedEmp.setAge(newEmp.getAge());
            return repository.save(updatedEmp);
        }
        else throw new UserNotFoundException("id="+id);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
