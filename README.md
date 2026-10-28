# HPE Employee Web Service

A Spring Boot REST web service for managing employee records, built while completing the
[Hewlett Packard Enterprise Software Engineering Job Simulation on Forage](https://www.theforage.com/).

This project is for learning and portfolio purposes and is not affiliated with or
endorsed by Hewlett Packard Enterprise.

See [docs/proposal.md](docs/proposal.md) for the original Task 1 proposal that this
implementation (Task 2) is based on.

## Status

🚧 In development. The domain model, employee manager, and core REST endpoints are
implemented with in-memory sample data, including adding employees via JSON `POST`
requests. Persistence, validation, and fuller tests are still to come.

## Tech Stack

- Java 17
- Spring Boot 4.1.1 (`spring-boot-starter-webmvc`)
- Gradle (wrapper included)
- JUnit 5

## Project Structure

```
src/main/java/com/hwewebservice/employees/
├── RestServiceApplication.java  # Spring Boot entry point
├── controller/
│   └── EmployeeController.java  # REST controller: GET/POST /employees
├── dao/
│   └── EmployeeManager.java     # In-memory data store, seeded with sample employees
└── model/
    ├── Employee.java            # Employee record: id, first/last name, email, title
    └── Employees.java           # Collection wrapper for Employee
```

## API Endpoints

| Method | Path              | Description                        |
|--------|-------------------|------------------------------------|
| GET    | `/employees`      | List all employees                 |
| GET    | `/employees/{id}` | Get a single employee by ID        |
| POST   | `/employees`      | Add a new employee                 |

The service starts with four sample employees pre-loaded in memory. New employees are
kept in memory only, so they are lost when the application restarts.

### Adding an employee

JSON fields use snake_case:

```bash
curl -X POST http://localhost:8080/employees \
  -H 'Content-Type: application/json' \
  -d '{
        "employee_id": "5",
        "first_name": "Jordan",
        "last_name": "Lee",
        "email": "jordan.lee@example.com",
        "title": "Data Analyst"
      }'
```

The response echoes the created employee. A subsequent `GET /employees` returns it
alongside the sample data, wrapped in an `employeeList` array.

## Getting Started

### Prerequisites

- JDK 17+

### Run the application

```bash
./gradlew bootRun
```

Or build and run the executable jar:

```bash
./gradlew bootJar
java -jar build/libs/employees-0.0.1-SNAPSHOT.jar
```

The service listens on `http://localhost:8080`.

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
