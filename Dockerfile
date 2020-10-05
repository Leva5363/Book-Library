FROM openjdk:8
#Copy code from local directory to work directory
COPY target/Checking_of_pass-1.0-SNAPSHOT.jar    /usr/home/lev.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/usr/home/lev.jar"]