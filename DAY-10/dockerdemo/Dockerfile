# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build

COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17.0.1-jdk-slim


# Copy the exact jar file from the build stage and rename it
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar springbootfirst.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springbootfirst.jar"]
