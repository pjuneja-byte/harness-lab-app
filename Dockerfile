# The jar is built and tested by the Harness CI "Maven Build and Test" step before this runs.
# eclipse-temurin publishes amd64 and arm64 variants, so the image is built for whatever CPU runs the build.
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/app.jar app.jar
EXPOSE 8080
USER 1000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
