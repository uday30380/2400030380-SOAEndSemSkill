# Stage 1: Build Stage
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven pom.xml and dependencies
COPY pom.xml .

# Copy application source code
COPY src ./src

# Build the application and package into an executable JAR
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
