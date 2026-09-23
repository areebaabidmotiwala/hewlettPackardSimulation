# HPE Employee Web Service

A Spring Boot REST web service for managing employee records, built while completing the
[Hewlett Packard Enterprise Software Engineering Job Simulation on Forage](https://www.theforage.com/).

This project is for learning and portfolio purposes and is not affiliated with or
endorsed by Hewlett Packard Enterprise.

## Status

🚧 In development. The domain model, DAO, and core REST endpoints are implemented
with in-memory sample data; persistence, validation, and tests are still to come.

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
│   └── employeecontroller.java # REST controller: GET/POST /employees
├── dao/
│   └── employeeDAO.java        # In-memory data store, seeded with sample employees
└── model/
    ├── employee.java           # Employee record: id, first/last name, email, title
    └── employees.java          # Collection wrapper for Employee
```

## API Endpoints

| Method | Path              | Description                        |
|--------|-------------------|------------------------------------|
| GET    | `/employees`      | List all employees                 |
| GET    | `/employees/{id}` | Get a single employee by ID        |
| POST   | `/employees`      | Add a new employee                 |

The service starts with four sample employees pre-loaded in memory.

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

- [ ] Add persistent storage (e.g. a database) in place of the in-memory list
- [ ] Add PUT/DELETE endpoints for updating and removing employees
- [ ] Add request/response validation
- [ ] Add unit and integration tests
- [ ] Add API documentation
