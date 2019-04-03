# Pull base image.
FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./build/libs/weeku-1.0-SNAPSHOT.jar service.jar

EXPOSE 8080

CMD java -jar service.jar
