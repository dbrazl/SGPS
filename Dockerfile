FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sgps.jar
CMD ["java","-jar","sgps.jar", "--server.port=5001"]