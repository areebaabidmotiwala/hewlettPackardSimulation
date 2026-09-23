# HPE Employee Web Service

A Spring Boot web service for managing employee records, built as a portfolio project.

## Status

🚧 Early development. The domain model is in place; the REST controller and data
access layer are stubbed out and not yet implemented.

## Tech Stack

- Java 17
- Spring Boot 4.1.1 (`spring-boot-starter-webmvc`)
- Gradle (wrapper included)
- JUnit 5

## Project Structure

```
src/main/java/com/hwewebservice/employees/
├── EmployeesApplication.java   # Spring Boot entry point
├── controller/
│   └── employeecontroller.java # REST controller (not yet implemented)
├── dao/
│   └── employeeDAO.java        # Data access layer (not yet implemented)
└── model/
    ├── employee.java           # Employee record: id, first/last name, email, title
    └── employees.java          # In-memory collection wrapper for Employee
```

## Getting Started

### Prerequisites

- JDK 17+

### Run the application

```bash
./gradlew bootRun
```

### Run tests

```bash
./gradlew test
```

## Roadmap

- [ ] Implement `EmployeeController` REST endpoints (CRUD)
- [ ] Implement `EmployeeDAO` for persistence
- [ ] Add request/response validation
- [ ] Add API documentation
