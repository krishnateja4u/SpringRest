FROM openjdk:8
ARG jarfile=target/*.jar
COPY ${ARG} springrest.jar
ENTRYPOINT ["java" "-jar" "/springrest.jar"]
EXPOSE 9295
