FROM openjdk:21
EXPOSE 8080
COPY target/analyticsapi.jar analyticsapi.jar
ENTRYPOINT ["java","-jar","/analyticsapi.jar"]

