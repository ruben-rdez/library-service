FROM openjdk:17
WORKDIR /app
COPY ./target/library-service.jar /app
EXPOSE 8080
CMD ["java", "-jar", "library-service.jar"]
