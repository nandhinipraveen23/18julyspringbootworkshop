# Use OpenJDK 17 as the base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY emprestapi/target/emprestapi-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=dev"]