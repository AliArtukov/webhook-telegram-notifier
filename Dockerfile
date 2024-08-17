FROM maven:3.9.6

LABEL maintainer="Ali Artukov"

SHELL ["/bin/bash", "-c"]

COPY target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8080