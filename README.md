# Spring Boot Project Architecture

This project demonstrates a typical **Spring Boot layered architecture**, following best practices for structuring applications with **Controller, Service, Repository, DTO, and Database layers**.

---

## Project Flow

1. **Frontend (Client)**
   - Makes a `POST` request to the backend (Spring Boot API).
   - Receives a response after processing.

2. **Controller Layer**
   - Handles **HTTP Requests and Responses**.
   - Converts incoming data to **DTOs** (Data Transfer Objects).
   - Passes DTOs to the Service layer.

3. **Service Layer**
   - Contains **business logic**.
   - Converts between **DTOs and domain models**.
   - Communicates with the Repository layer.

4. **Repository Layer**
   - Interacts directly with the **database**.
   - Executes queries and returns data as domain models.

5. **Database**
   - Stores persistent data.
   - Returns query results to the repository.

---

## Technologies Used

- **Spring Boot** (Backend framework)  
- **Spring Web** (RESTful APIs)  
- **Spring Data JPA / Hibernate** (Database interaction)  
- **H2 / MySQL / PostgreSQL** (Configurable database)  
- **Lombok** (Boilerplate code reduction)  
- **Maven/Gradle** (Build tool)  

---

## API Example
- POST /api/sample → Create a new record
- GET /api/sample/{id} → Get record by ID
- PUT /api/sample/{id} → Update record
- DELETE /api/sample/{id} → Delete record

##  Features
- Clean separation of concerns
- DTOs for safe data transfer
- Business logic handled in Service layer
- Repository pattern for database queries
- Easy to extend and maintain

