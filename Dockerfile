FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN chmod +x /app/mvnw
RUN /app/mvnw clean package -DskipTests
ENTRYPOINT ["java", "-jar", "/app/target/EmailService-0.0.1-SNAPSHOT.jar"]