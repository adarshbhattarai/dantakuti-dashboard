FROM java:8
VOLUME /tmp
ADD target/dashboard.jar dashboard.jar
EXPOSE 8080
RUN bash -c ‘touch /dashboard.jar’
ENTRYPOINT [“java”,”-Dspring.data.mongodb.uri=mongodb://mongo/test”, “-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/dashboard.jar”]
