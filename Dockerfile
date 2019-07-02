FROM openjdk:8
ADD target/dashboard.jar dashboard.jar
EXPOSE 8080
ENTRYPOINT java -jar dashboard.jar
