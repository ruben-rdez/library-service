FROM amazoncorretto:21.0.4-alpine3.18
WORKDIR /app
COPY ./target/library-service.jar /app
EXPOSE 8080
CMD ["java", "-jar", "library-service.jar"]