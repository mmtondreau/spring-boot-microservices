FROM tonberry/spring-jdk17:latest

COPY target/EurekaServer.jar /EurekaServer.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/EurekaServer.jar"]
