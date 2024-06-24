# Security_SpringSecurity_JWT

This project is a secure API application built with Spring Boot. It features JWT-based authentication and role-based access control.

## Features

- **JWT Authentication**: Secure authentication using JSON Web Tokens (JWT).
- **Role-based Access Control**: Different endpoints for users with `USER` and `ADMIN` roles.
- **Secure Endpoints**:
  - Public endpoint accessible to all.
  - User endpoint accessible to authenticated users with `USER` role.
  - Admin endpoint accessible to authenticated users with `ADMIN` role.

## Endpoints

### Public Endpoint

- **URL**: `/api/public`
- **Method**: `GET`
- **Description**: Accessible by everyone.

### User Endpoint

- **URL**: `/api/user`
- **Method**: `GET`
- **Description**: Accessible by users with `USER` role.

### Admin Endpoint

- **URL**: `/api/admin`
- **Method**: `GET`
- **Description**: Accessible by users with `ADMIN` role.

