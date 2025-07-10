# Email Service by Raveendra - v1.0

A simple resilient email service built with the Spring Boot for educational purposes, demonstrating mock email sending with retry logic.

## Setup Instructions

1.Clone the repository to your local machine: `git clone <your-repo-url>`.

2.Move into the project directory: `cd emailservice`.

3.Build the project with Maven: `mvn clean install`.

4.Start the application using Maven: `mvn spring-boot:run`, or run `EmailServiceApplication` directly in your IDE (e.g., IntelliJ or Eclipse).

5.Test the API endpoint with Postman:
   - Method: POST
   - URL: `http://localhost:8080/api/email/send`
   - Parameters: `email=Greetings, hope your well!` and `to=user@example.com`.

## Assumptions

- Uses a mock email provider with a 70% success rate.

- Implements up to 2 retry attempts with a 1-second delay between tries.

- Excludes persistent storage and rate limiting for simplicity.

- Accepts any non-empty string for the `to` parameter (no email format validation).