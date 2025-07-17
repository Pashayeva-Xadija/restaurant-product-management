FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/restaurant-product-management.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
