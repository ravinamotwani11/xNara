FROM openjdk:11

COPY api/build/libs/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar.jar

EXPOSE 8080

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]