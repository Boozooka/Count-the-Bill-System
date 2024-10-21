FROM maven:3.9.4-eclipse-temurin-17 as build

COPY src src
COPY pom.xml pom.xml

RUN mvn clean package

FROM bellsoft/liberica-openjdk-debian:17 as jarapp

WORKDIR /app

COPY --from=build target/CountingTheBillSystem-1.0-SNAPSHOT.jar ./application.jar

ENTRYPOINT ["java", "-jar", "./application.jar"]
