FROM pht/parent-spring:latest

ARG JAR_FILE
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "http://station-office:6006/actuator/health",  "-wait", "http://train-router:6004/actuator/health", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=denbi"]
EXPOSE 6011

