
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package \
 && cp target/*.jar /app/app.jar
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/app.jar /app/app.jar
EXPOSE 5050
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java -Dserver.port=${PORT:-5050} -Dserver.address=0.0.0.0 $JAVA_OPTS -jar /app/app.jar"]
