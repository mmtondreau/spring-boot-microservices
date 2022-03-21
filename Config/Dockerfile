FROM tonberry/spring-jdk17:latest
ENV eurekaZone "http://eureka:8761/eureka/"
COPY target/Config.jar /Config.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Config.jar"]
