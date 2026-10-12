# ==========================================
# Stage 1: Build & Package (Java 17 JDK)
# ==========================================
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy only pom.xml first to leverage Docker layer caching for dependencies
COPY pom.xml .

# Download dependencies (cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy application source code
COPY src ./src

# Package the Spring Boot application (skipping tests for container packaging)
RUN mvn clean package -DskipTests

# ==========================================
# Stage 2: Runtime Environment (Java 17 JRE)
# ==========================================
FROM eclipse-temurin:17-jre-jammy AS runtime

WORKDIR /app

# Create a non-privileged user and group for production security
RUN addgroup --system spring && adduser --system --ingroup spring spring

# Copy the compiled JAR artifact from the builder stage
# Using wildcard matching to handle any versioning changes seamlessly
COPY --from=builder --chown=spring:spring /app/target/*.jar /app/app.jar

# Switch to non-root user
USER spring:spring

# Expose default Spring Boot application port
EXPOSE 8080

# Environment options: Enable container support and sensible memory boundaries
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Execute application using exec so Java runs as PID 1 to handle SIGTERM signals gracefully
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]

