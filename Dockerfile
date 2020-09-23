FROM openjdk:14-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /home/spring

COPY /target/*.jar application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]