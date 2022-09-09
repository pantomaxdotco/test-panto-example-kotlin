FROM openjdk:18.0.2.1

COPY build/libs/spring-restapi-0.0.1-SNAPSHOT.jar /application/app.jar

CMD ["java", "-jar", "application/app.jar"]