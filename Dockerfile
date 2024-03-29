#Author: Tran Anh Hoang

FROM maven:3.8.5-openjdk-11-slim as build
WORKDIR /workspace/app

# Copy POM
COPY pom.xml .
# get all the downloads out of the way
RUN mvn dependency:go-offline

# Build sources
COPY src src
RUN mvn package -DskipTests

FROM openjdk:11.0.15-jre-buster
ARG DEPENDENCY=/workspace/app/target

# Copy build results
WORKDIR /app
COPY --from=build ${DEPENDENCY}/lib ./lib
COPY --from=build ${DEPENDENCY}/jab-server.jar .

# Specify listening port
EXPOSE 8080

# Define Entrypoint, e.g. just run our creates JAR file
ENTRYPOINT ["java", "-jar", "jab-server.jar"]
