package com.hwewebservice.employees.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tools.jackson.databind.json.JsonMapper;

// Plain JUnit tests: no Spring context is started, so these run fast.
class EmployeeTest {

    // The same JSON library Spring uses to read POST bodies and write responses
    private final JsonMapper mapper = JsonMapper.builder().build();

    @Test
    void constructorSetsAllFields() {
        // Arrange + Act
        Employee employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer");

        // Assert: expected value first, actual value second
        assertEquals("1", employee.getEmployeeId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("Software Engineer", employee.getTitle());
    }

    @Test
    void noArgConstructorLeavesFieldsNull() {
        Employee employee = new Employee();

        assertNull(employee.getEmployeeId());
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
        assertNull(employee.getEmail());
        assertNull(employee.getTitle());
    }

    @Test
    void settersUpdateValuesReturnedByGetters() {
        Employee employee = new Employee();

        employee.setEmployeeId("5");
        employee.setFirstName("Jordan");
        employee.setLastName("Lee");
        employee.setEmail("jordan.lee@example.com");
        employee.setTitle("Data Analyst");

        assertEquals("5", employee.getEmployeeId());
        assertEquals("Jordan", employee.getFirstName());
        assertEquals("Lee", employee.getLastName());
        assertEquals("jordan.lee@example.com", employee.getEmail());
        assertEquals("Data Analyst", employee.getTitle());
    }

    @Test
    void deserializesSnakeCaseJson() {
        // This is the exact request body shape the task requires for POST /employees
        String json = """
                {
                    "employee_id": "5",
                    "first_name": "Jordan",
                    "last_name": "Lee",
                    "email": "jordan.lee@example.com",
                    "title": "Data Analyst"
                }
                """;

        Employee employee = mapper.readValue(json, Employee.class);

        assertEquals("5", employee.getEmployeeId());
        assertEquals("Jordan", employee.getFirstName());
        assertEquals("Lee", employee.getLastName());
        assertEquals("jordan.lee@example.com", employee.getEmail());
        assertEquals("Data Analyst", employee.getTitle());
    }

    @Test
    void serializesToSnakeCaseJson() {
        Employee employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer");

        String json = mapper.writeValueAsString(employee);

        // Responses should use the same snake_case keys, not camelCase like "employeeId"
        assertTrue(json.contains("\"employee_id\":\"1\""));
        assertTrue(json.contains("\"first_name\":\"John\""));
        assertTrue(json.contains("\"last_name\":\"Doe\""));
        assertTrue(json.contains("\"email\":\"john.doe@example.com\""));
        assertTrue(json.contains("\"title\":\"Software Engineer\""));
    }
}
