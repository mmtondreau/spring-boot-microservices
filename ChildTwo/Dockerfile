FROM tonberry/spring-jdk17:latest
ENV eurekaZone "http://eureka:8761/eureka/"
COPY target/ChildTwo.jar /ChildTwo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ChildTwo.jar"]