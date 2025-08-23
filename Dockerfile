FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests clean package && cp target/*.jar /app/app.jar

FROM eclipse-temurin:17-jre
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
WORKDIR /app
COPY --from=build /app/app.jar /app/app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java \
 -Dserver.port=${PORT:-8080} -Dserver.address=0.0.0.0 \
 -Dspring.datasource.url=\"$SPRING_DATASOURCE_URL\" \
 -Dspring.datasource.username=\"$SPRING_DATASOURCE_USERNAME\" \
 -Dspring.datasource.password=\"$SPRING_DATASOURCE_PASSWORD\" \
 $JAVA_OPTS -jar /app/app.jar"]
