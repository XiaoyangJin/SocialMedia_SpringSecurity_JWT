# SocialMedia_SpringSecurity_JWT
Secure Social Media API with Role-Based Access Control Using Spring Boot

## Overview

This project is a secure social media application API built with Spring Boot. It features JWT-based authentication and role-based access control. Authenticated users can view all posts, while only users with the 'ADMIN' role can create, update, and delete posts.

## Features

- JWT-based authentication
- Role-based access control with Spring Security
- CRUD operations on `Post` entity
- Secure endpoints for creating, updating, and deleting posts (admin only)
- User registration and authentication

## Technologies Used

- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA/Hibernate
- MySQL (or any other relational database)
- Maven

## API Endpoints
### Authentication and Registration
- Register a new user
```POST /auth/register
Content-Type: application/json
{
  "username": "user",
  "password": "password"
}```

- Authenticate a user and get a JWT
POST /auth/authenticate
Content-Type: application/json
{
  "username": "user",
  "password": "password"
}

### Post Management
- Get all posts (authenticated users)
GET /posts
Authorization: Bearer <JWT>

- Get a specific post by ID (authenticated users)
GET /posts/{id}
Authorization: Bearer <JWT>

- Create a new post (admin only)
POST /posts
Content-Type: application/json
Authorization: Bearer <JWT>
{
  "title": "New Post",
  "content": "This is the content of the new post."
}

- Update a post (admin only)
PUT /posts/{id}
Content-Type: application/json
Authorization: Bearer <JWT>
{
  "title": "Updated Post",
  "content": "This is the updated content of the post."
}

- Delete a post (admin only)
DELETE /posts/{id}
Authorization: Bearer <JWT>

## License
This project is licensed under the MIT License. See the LICENSE file for details.
