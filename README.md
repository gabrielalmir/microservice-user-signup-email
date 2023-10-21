# Simple Microservice : User & Email

The main goal of this project is to practice the basic principles of microservices by implementing two microservices. Once a user is registered, the system dispatches an email confirming the signup.

## Requirements

- Java : JDK-17
- Spring Boot : 3+
- Docker for RabbitMQ and PostgresSQL
- Maven

You need to specify the EMAIL_SMTP, EMAIL_USERNAME and EMAIL_PASSWORD in enviroment of `email` microservice before running.
