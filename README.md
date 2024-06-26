# TaskFlow Microservice System Back End

## Overview
The Task Management Project is a comprehensive system designed to streamline task management and enhance productivity through a microservice architecture. This project utilizes Spring Boot for backend services, PostgreSQL for data storage, and various other technologies to ensure robust performance, scalability, and security.

## Technology Stack
- **Spring Boot:** For creating standalone, production-grade Spring-based applications.
- **PostgreSQL:** An open-source relational database for data storage.
- **Spring JPA:** For ORM (Object Relational Mapping) to manage database interactions.
- **WebSocket:** For real-time communication between the client and the server.
- **Spring Cloud Gateway:** For routing and load balancing of API requests.
- **RBAC (Role-Based Access Control):** For secure user management.
- **Netflix Eureka Client:** For service discovery in a microservice architecture.
- **OpenFeign:** For making HTTP requests between microservices.

## Features
- **Microservice Architecture:** Ensures modularity, scalability, and maintainability.
- **Real-time Notifications:** Utilizes WebSocket for instant task updates and notifications.
- **API Gateway:** Manages and routes API requests efficiently.
- **Role-Based Access Control:** Enhances security by managing user permissions.
- **Service Discovery:** Uses Netflix Eureka for locating services for load balancing and failover of middle-tier servers.
- **Inter-service Communication:** Facilitates HTTP requests between microservices using OpenFeign.

## Installation

To run this project locally, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/Li-8023/task-management.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd task-management
    ```
3. **Install dependencies:**
    ```bash
    ./mvnw install
    ```
4. **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage

Once the application is running, you can interact with it via API endpoints. The system supports various functionalities such as user management, task creation, task updates, assign task, and real-time notifications.


## Front End Repository

The front-end code for this project is available in a separate repository. You can find it here: [Task Management Front End](https://github.com/Li-8023/task-management-frontend)

## Showcase Video
Watch the project showcase video on YouTube to see the Task Management Front End in action:

[![Task Management Front End](https://img.youtube.com/vi/Quw7Xhc3hD0/0.jpg)](https://youtu.be/Quw7Xhc3hD0)
