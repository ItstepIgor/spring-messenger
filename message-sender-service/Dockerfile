FROM gradle:jdk11 as builder
COPY . /home/gradle
RUN gradle clean bootJar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /home/gradle/build/libs/*.jar ./message-sender-service.jar
COPY ./entrypoint.sh /usr/bin/entrypoint.sh
ENTRYPOINT [ "entrypoint.sh", "message-sender-service.jar" ]