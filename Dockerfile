# Means to build our image upon java 13 image from Docker Hub
FROM openjdk:13
# This be me
MAINTAINER cgannaway
# Add the spring boot jar file from the local file system and rename it to app.jar
ADD build/libs/banter-board-backend-0.0.1-SNAPSHOT.jar app.jar
# Open port 8080 on the container
EXPOSE 8080
# The ENTRYPOINT command is the “what to run to ‘start'” command
ENTRYPOINT ["java","-jar","/app.jar"]