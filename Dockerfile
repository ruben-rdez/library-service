FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar library-service.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","library-service.jar"]
