FROM openjdk:17
MAINTAINER phuongchu
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN ./mvnw dependency:go-offline
CMD ["./mvnw", "spring-boot:run"]
