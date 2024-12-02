FROM openjdk:17-jdk
RUN mkdir /rediscache
WORKDIR /rediscache
COPY target/*.jar /rediscache/rediscache.jar
CMD ["java", "-jar", "/rediscache/rediscache.jar"]
