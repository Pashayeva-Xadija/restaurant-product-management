
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package && cp target/*.jar app.jar
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/app.jar app.jar
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
