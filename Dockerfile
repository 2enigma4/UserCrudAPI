FROM openjdk:17
VOLUME /tmp
COPY target/myspringapp.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]