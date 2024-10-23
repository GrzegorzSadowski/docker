# Stage 1: Build the application
FROM maven:3.8.8-eclipse-temurin-17 AS builder

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the pom.xml to download the dependencies
COPY pom.xml .

# Copy the source code to the container
COPY src ./src

# Package the application (without running tests)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=builder /app/target/*.jar ./app.jar

ENV DEVOPS="Grzegorz"

# Expose the port on which the application will run
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
