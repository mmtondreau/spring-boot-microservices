FROM tonberry/spring-jdk17:latest
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
#ENTRYPOINT [ "tail", "-f", "/dev/null"]
ENTRYPOINT ["java","-cp","app:app/lib/*","org.tonberry.eureka.childtwo.Application"]
