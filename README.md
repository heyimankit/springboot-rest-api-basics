# Spring Boot REST API Basics

A beginner Spring Boot REST API project demonstrating how to build HTTP endpoints and return JSON responses.

## Concepts Covered

* REST APIs
* @RestController
* @RequestMapping
* @GetMapping
* @PathVariable
* @RequestParam
* DTO (Data Transfer Object)
* JSON Response Generation

## Project Structure

### EmployeeController

Contains REST endpoints for handling employee-related requests.

Endpoints:

* GET /employees/{employeeId}
* GET /employees?age=25&name=Ankit

### EmployeeDTO

Represents employee data returned by the API.

Fields:

* id
* name
* email
* age
* dateOfJoining
* isActive

## Technologies Used

* Java 17
* Spring Boot
* Maven

## Learning Outcomes

Through this project, I learned:

* How REST APIs work in Spring Boot
* How to create API endpoints
* How to extract values using @PathVariable
* How to read query parameters using @RequestParam
* How DTOs are used to transfer data
* How Spring Boot automatically converts Java objects to JSON

## Run the Application

```bash
mvn spring-boot:run
```

## Sample API Calls

### Get Employee by ID

```http
GET /employees/1
```

### Get Employees with Query Parameters

```http
GET /employees?age=25&name=Ankit
```

## Author

Ankit Shaw
