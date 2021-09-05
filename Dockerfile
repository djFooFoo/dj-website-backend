FROM maven:3.6-openjdk-15 AS build

COPY src app/src
COPY pom.xml app
RUN mvn -f app/pom.xml clean package -DskipTests

FROM adoptopenjdk/openjdk15:x86_64-ubuntu-jre15u-nightly
EXPOSE 10000
RUN mkdir /app
COPY --from=build app/target/*.jar /app/application.jar

ENTRYPOINT ["java" ,"-jar", "/app/application.jar"]
