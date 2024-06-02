FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

COPY . .

RUN  sh ./gradlew --no-daemon clean bootJar

FROM eclipse-temurin:17-jre-alpine as runner
ARG JARFILE=*.jar
COPY --from=builder /app/build/libs/${JARFILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]