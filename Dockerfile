FROM maven:3.6-openjdk-15 AS build

COPY src app/src
COPY pom.xml app
RUN mvn -f app/pom.xml clean package -DskipTests

FROM openjdk:15-jdk
EXPOSE 8080
RUN mkdir /app
COPY --from=build app/target/*.jar /app/application.jar

ENTRYPOINT ["java" ,"-jar", "/app/application.jar"]
