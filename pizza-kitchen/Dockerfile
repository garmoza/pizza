FROM openjdk:18

WORKDIR /app
COPY ./target/pizza-kitchen-0.0.2-SNAPSHOT.jar .

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app/pizza-kitchen-0.0.2-SNAPSHOT.jar"]