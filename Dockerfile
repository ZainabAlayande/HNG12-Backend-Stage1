# Use a lightweight JDK image for building the application
FROM eclipse-temurin:17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and project files
COPY gradlew build.gradle settings.gradle ./
COPY src ./src

# Grant permission to Gradle wrapper and build the app
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon

# Use a lightweight JRE image for running the application
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Expose port 8081 for the application
EXPOSE 8081

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
