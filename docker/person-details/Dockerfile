FROM openjdk:11-jdk AS builder
COPY . /source
WORKDIR /source
RUN ./gradlew bootJar

FROM openjdk:11-jdk
COPY --from=builder /source/build/libs/person-details-0.0.1.jar /app/
WORKDIR /app
EXPOSE 8080
EXPOSE 5005
CMD ["./gradlew", "bootRun"]
