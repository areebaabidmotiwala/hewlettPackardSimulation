package com.hwewebservice.employees.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hwewebservice.employees.dao.EmployeeManager;
import com.hwewebservice.employees.model.Employee;
import com.hwewebservice.employees.model.Employees;

// Mockito unit tests: the controller is tested on its own, with a fake ("mock")
// EmployeeManager. That way a test only fails if the controller itself is wrong.
@ExtendWith(MockitoExtension.class) // lets Mockito create the @Mock and @InjectMocks fields
class EmployeeControllerTest {

    // A fake EmployeeManager. Its methods do nothing and return null
    // until we tell them what to return with when(...).thenReturn(...)
    @Mock
    private EmployeeManager employeeManager;

    // A real EmployeeController, built with the mock passed into its constructor
    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void getAllEmployeesReturnsWhatManagerReturns() {
        // Arrange: tell the mock what to return
        Employees employees = new Employees();
        employees.getEmployeeList().add(new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        when(employeeManager.getAllEmployees()).thenReturn(employees);

        // Act
        Employees result = employeeController.getAllEmployees();

        // Assert: the controller passes the manager's result straight through
        assertSame(employees, result);
    }

    @Test
    void getEmployeeByIdReturnsEmployeeWhenFound() {
        Employee employee = new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Project Manager");
        when(employeeManager.getEmployeeById("2")).thenReturn(employee);

        Employee result = employeeController.getEmployeeById("2");

        assertSame(employee, result);
    }

    @Test
    void getEmployeeByIdThrowsWhenNotFound() {
        // The manager returns null for an unknown ID
        when(employeeManager.getEmployeeById("99")).thenReturn(null);

        // assertThrows runs the lambda and passes only if it throws this exception type
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> employeeController.getEmployeeById("99"));

        assertEquals("Employee with ID 99 not found.", exception.getMessage());
    }

    @Test
    void addEmployeeSavesEmployeeAndReturnsIt() {
        Employee employee = new Employee("5", "Jordan", "Lee", "jordan.lee@example.com", "Data Analyst");

        Employee result = employeeController.addEmployee(employee);

        // verify checks that the controller called the manager with this exact employee
        verify(employeeManager).addEmployee(employee);
        assertSame(employee, result);
    }
}
