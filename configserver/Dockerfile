FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar ConfigServer.jar
ENTRYPOINT [ "java", "-jar", "ConfigServer.jar" ]