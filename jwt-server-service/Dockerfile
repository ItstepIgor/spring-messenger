FROM gradle:jdk11 as builder
COPY . /home/gradle
RUN gradle clean bootJar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /home/gradle/build/libs/*.jar ./jwt-server-service.jar
CMD java -jar jwt-server-service.jar