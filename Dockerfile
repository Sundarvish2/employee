FROM eclipse-temurin:17
COPY target/pause.jar pause.jar
CMD ["java","-jar","pause.jar"]