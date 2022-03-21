FROM tonberry/spring-jdk17:latest
ENV eurekaZone "http://eureka:8761/eureka/"
COPY target/Parent.jar /Parent.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Parent.jar"]
