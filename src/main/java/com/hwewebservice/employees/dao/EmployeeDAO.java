package com.hwewebservice.employees.dao;

import org.springframework.stereotype.Repository;

import com.hwewebservice.employees.model.Employee;
import com.hwewebservice.employees.model.Employees;

@Repository
public class EmployeeDAO {
    private final Employees employees = new Employees();

    public EmployeeDAO() {
        // Initialize with some sample data
        employees.getEmployeeList().add(new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        employees.getEmployeeList().add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Project Manager"));
        employees.getEmployeeList().add(new Employee("3", "Alice", "Johnson", "alice.johnson@example.com", "HR Specialist"));
        employees.getEmployeeList().add(new Employee("4", "Bob", "Brown", "bob.brown@example.com", "Sales Associate"));
    }

    //returns the list of employees
    public Employees getAllEmployees(){
        return employees;
    }

    public Employee getEmployeeById(String id) {
        return employees.getEmployeeList().stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }
}