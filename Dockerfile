FROM eclipse-temurin:22-jdk
COPY target/customer-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
