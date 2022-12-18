FROM gradle:jdk11 as builder
COPY . /home/gradle
RUN gradle clean bootJar

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /home/gradle/build/libs/*.jar ./avatar-service.jar
COPY ./entrypoint.sh /usr/bin/entrypoint.sh
ENTRYPOINT [ "entrypoint.sh", "avatar-service.jar" ]