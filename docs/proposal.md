# Project Proposal (Task 1)

This is the original proposal written for Task 1 of the Hewlett Packard Enterprise
Software Engineering Job Simulation on Forage. Task 2 (this repository) is the
implementation that followed from it. Some details below (e.g. the persistence
layer and full layered architecture) reflect the original proposed design and
have not all been built yet — see the [README](../README.md) for current status.

---

I propose to develop an Employee Repository Application for Hewlett Packard Enterprise (HPE)
to provide a simple and secure solution for accessing, storing and managing employee data. The
application will use Java Spring Boot REST Services for Backend and API Calling. The
application will follow a layered architecture consisting of seven layers making the application
easier to maintain and scale.

The application architecture is as follows:

1. **Config**: Manages application configuration and security.
2. **Controller**: Handles HTTP requests and performs input validation.
3. **DTO**: Decouples the API request/response format from the internal database model.
4. **Exception**: Provides centralized global exception handling.
5. **Model**: Contains JPA entities representing database tables.
6. **Repository**: Provides the data access layer.
7. **Service**: Contains the application's business logic.

The REST API will support the following operations:

1. **GET /employees**: Retrieves the complete list of employees.
2. **GET /employees/{id}**: Retrieves a specific employee by ID.
3. **POST /employees**: Creates a new employee and returns the newly created employee with
   a success message.
4. **PUT /employees/{id}**: Updates an existing employee and returns the updated employee.
5. **DELETE /employees/{id}**: Deletes an employee and returns a success/error message.

Requests and responses will use JSON payloads, with each employee record containing five
fields: first_name, last_name, employee_id, email, and title. Spring Data JPA will manage
persistence and database interactions with the EDB PostgreSQL database.

For hosting, employee data will be stored in an EDB PostgreSQL database hosted on HPE
GreenLake's private cloud infrastructure. EDB PostgreSQL is selected due to its low
licensing cost and ability to scale reliably as the volume of employee data increases.
GreenLake provides the application with the benefits of a private cloud, including
centralized management, flexibility, scalability, and greater control over infrastructure.

Security will be supported through HPE GreenLake's identity and access management, role-
based permissions, encryption, resource-level access policies, and threat detection
capabilities. This approach provides a secure, scalable, and maintainable solution that
meets the requirements of an enterprise employee repository.
