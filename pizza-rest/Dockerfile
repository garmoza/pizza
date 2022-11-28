FROM openjdk:18

WORKDIR /app
COPY ./target/pizza-rest-0.0.2-SNAPSHOT.jar .

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/pizza-rest-0.0.2-SNAPSHOT.jar"]