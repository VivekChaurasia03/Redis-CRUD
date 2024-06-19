# Redis CRUD Application

This project is a basic CRUD (Create, Read, Update, Delete) operations application using Redis as the data store. The application is built with Spring Boot and leverages Redis for fast and efficient data management. This repository serves as a learning tool for understanding how to integrate Redis with a Spring Boot application.

## Features

- **Create**: Add new user data to the Redis database.
- **Read**: Retrieve user data from the Redis database using user ID.
- **Update**: Modify existing user data in the Redis database.
- **Delete**: Remove user data from the Redis database.

## Technologies Used

- **Spring Boot**: Framework for building Java-based applications.
- **Redis**: In-memory data structure store, used as a database, cache, and message broker.
- **Lettuce**: Redis client for Java.
- **Maven**: Dependency management and build tool.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java 11 or higher
- Maven
- Redis server

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/VivekChaurasia03/Redis-CRUD.git
cd Redis-CRUD
```

### Configure Redis

Ensure that your Redis server is running. You can configure the Redis connection details (host and port) in the `application.properties` or `env.properties` file.

### Environment Variables

You can set the following environment variables in a `env.properties` file in the root directory of your project:

```env
SPRING_DATA_REDIS_HOST=localhost
SPRING_DATA_REDIS_PORT=6379
```

### Running the Application

Use the following commands to build and run the application:

```sh
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### Create User

- **URL**: `/users`
- **Method**: `POST`
- **Description**: Create a new user.
- **Request Body**: JSON object containing user details.

### Get User by ID

- **URL**: `/users/{userId}`
- **Method**: `GET`
- **Description**: Retrieve user details by user ID.

### Update User

- **URL**: `/users/{userId}`
- **Method**: `PUT`
- **Description**: Update existing user details.
- **Request Body**: JSON object containing updated user details.

### Delete User

- **URL**: `/users/{userId}`
- **Method**: `DELETE`
- **Description**: Delete a user by user ID.

### Get All Users

- **URL**: `/users`
- **Method**: `GET`
- **Description**: Retrieve all users.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── src
│   │           └── practiceredis
│   │               ├── config
│   │               │   └── RedisConfiguration.java
│   │               ├── controllers
│   │               │   └── UserController.java
│   │               ├── dao
│   │               │   └── UserDao.java
│   │               ├── models
│   │               │   └── User.java
│   │               └── PracticeRedisApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── src
                └── practiceredis
                    └── PracticeRedisApplicationTests.java
```