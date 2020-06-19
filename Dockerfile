FROM openjdk:8
COPY target/*.jar /usr/home/lev.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/usr/home/lev.jar"]