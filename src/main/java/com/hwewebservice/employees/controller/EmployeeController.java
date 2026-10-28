package com.hwewebservice.employees.controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import com.hwewebservice.employees.model.Employees;
import com.hwewebservice.employees.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;

import com.hwewebservice.employees.dao.EmployeeManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    public Employees getAllEmployees() {
        return employeeManager.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        Employee employee = employeeManager.getEmployeeById(id);
        if(employee == null){
            throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }
        return employee;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return employee;        
    }
    
}