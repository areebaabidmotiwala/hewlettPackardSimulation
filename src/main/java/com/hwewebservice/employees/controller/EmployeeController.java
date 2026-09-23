package com.hwewebservice.employees.controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import com.hwewebservice.employees.model.Employees;
import com.hwewebservice.employees.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;

import com.hwewebservice.employees.dao.EmployeeDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public Employees getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if(employee.getEmployeeId() == null){
            throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }
        return employeeDAO.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeDAO.addEmployee(employee);
        return employee;        
    }
    
}