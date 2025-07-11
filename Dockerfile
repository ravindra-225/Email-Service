FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java", "-jar", "target/EmailService-0.0.1-SNAPSHOT.jar"]