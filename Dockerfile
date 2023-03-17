FROM openjdk:17
ARG jarfile=target/*.jar
COPY ${jarfile} springrest.jar
ENTRYPOINT ["java", "-jar", "/springrest.jar"]
EXPOSE 9295