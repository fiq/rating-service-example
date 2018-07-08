FROM openjdk:8-jre-alpine
WORKDIR /opt/parental-control-service
COPY ./build/libs/parental-control-service-0.0.1-SNAPSHOT.jar parental-control-service.jar
RUN adduser -D parental-control
USER parental-control
EXPOSE 8080
CMD ["java", "-jar", "parental-control-service.jar"]

