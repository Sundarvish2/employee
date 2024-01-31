FROM eclipse-temurin:17
COPY target/emp.jar emp.jar
CMD ["java","-jar","emp.jar"]