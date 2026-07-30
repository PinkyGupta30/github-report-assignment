# GitHub Repository Access Report

## Overview
This project is a Spring Boot REST API that connects to the GitHub REST API and generates a report showing which users have access to which repositories within a GitHub organization.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- GitHub REST API
- RestTemplate

## Authentication
The application authenticates using a GitHub Personal Access Token (PAT).

Configure the following properties in `application.properties`:

```properties
github.base-url=https://api.github.com
github.token=YOUR_GITHUB_PERSONAL_ACCESS_TOKEN
```

## How to Run

1. Clone the repository.
2. Open it in IntelliJ IDEA.
3. Configure the GitHub PAT.
4. Run the Spring Boot application.
5. Access:

```
GET http://localhost:8080/api/access-report/{organization}
```

## API Endpoints

### Get Repositories
```
GET /api/repos/{organization}
```

### Get Collaborators
```
GET /api/collaborators/{owner}/{repository}
```

### Get Access Report
```
GET /api/access-report/{organization}
```

## Design Decisions

- Layered architecture (Controller, Service, Client)
- DTOs for GitHub API responses
- Business logic separated from API communication

## Assumptions

- Valid GitHub PAT is configured
- User has access to the GitHub organization

## Scalability

The current implementation works correctly.

For larger organizations (100+ repositories and 1000+ users), performance can be improved by:
- Parallel API calls using CompletableFuture
- Caching
- Pagination
- Retry mechanism
