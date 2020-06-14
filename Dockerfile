FROM openjdk:8
COPY target/Checking_of_pass-1.0-SNAPSHOT.jar /usr/home/lev-docker.jar
ENTRYPOINT ["java", "-jar","/usr/home/lev-docker.jar"]