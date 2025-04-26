# 🛡️ Spring Boot Backend - JWT Authentication, DTO Mapper & Custom Exception Handling

This project is a **Spring Boot backend** implementing secure authentication and clean architecture best practices.  
It uses **JWT** for stateless authentication, **Spring Security** for securing endpoints, **DTOs** for clean data transfer, and **Custom Exception Handling** for consistent error responses.

---

## 🚀 Features

- ✅ **JWT Authentication**
  - Secure login with token generation
  - Token validation for protected routes
  - Stateless authentication using JWT

- ✅ **Spring Security Integration**
  - Role-based access control
  - Authentication and authorization filters
  - Secure password storage using BCrypt

- ✅ **DTO and Mapper Layer**
  - Clean separation between Entity and exposed data
  - MapStruct (or manual mapping) for converting between Entity and DTO
  - Reduces overexposing sensitive fields

- ✅ **Custom Exception Handling**
  - Global error handler with `@ControllerAdvice`
  - Returns consistent JSON error responses
  - Handles common errors like BadRequest, Unauthorized, NotFound

- ✅ **Clean Project Structure**
  - Follows layered architecture: Controller → Service → Repository
  - Easy to extend and maintain

---

## 📦 Tech Stack

- **Backend**: Java 17, Spring Boot 3
- **Security**: Spring Security + JWT
- **Data Access**: Spring Data JPA (Hibernate)
- **Database**: MySQL
- **Build Tool**: Maven


