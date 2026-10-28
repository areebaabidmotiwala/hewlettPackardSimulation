package com.hwewebservice.employees.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hwewebservice.employees.model.Employee;

// Plain JUnit tests for the in-memory data store.
// JUnit creates a new instance of this class for every test, so each test
// gets a fresh EmployeeManager with only the 4 sample employees.
public class EmployeeManagerTest {

    private final EmployeeManager employeeManager = new EmployeeManager();

    @Test
    void getAllEmployeesReturnsFourSampleEmployees() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertEquals(4, employees.size());
        assertEquals("John", employees.get(0).getFirstName());
    }

    @Test
    void getEmployeeByIdReturnsMatchingEmployee() {
        // Act: look up one of the sample employees
        Employee employee = employeeManager.getEmployeeById("2");

        // Assert: we got an employee back, and it's the right one
        assertNotNull(employee);
        assertEquals("Jane", employee.getFirstName());
        assertEquals("Smith", employee.getLastName());
    }

    @Test
    void getEmployeeByIdReturnsNullForUnknownId() {
        // No sample employee has ID 99, so the manager should return null
        assertNull(employeeManager.getEmployeeById("99"));
    }

    @Test
    void addEmployeeIncreasesListSize() {
        // Arrange
        Employee newEmployee = new Employee("5", "Jordan", "Lee", "jordan.lee@example.com", "Data Analyst");

        // Act
        employeeManager.addEmployee(newEmployee);

        // Assert: 4 sample employees + 1 new one
        assertEquals(5, employeeManager.getAllEmployees().getEmployeeList().size());
    }

    @Test
    void addedEmployeeCanBeFoundById() {
        Employee newEmployee = new Employee("5", "Jordan", "Lee", "jordan.lee@example.com", "Data Analyst");

        employeeManager.addEmployee(newEmployee);

        // assertSame checks it's the exact same object we added, not just an equal-looking one
        assertSame(newEmployee, employeeManager.getEmployeeById("5"));
    }
}
