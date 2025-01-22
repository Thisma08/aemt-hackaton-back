FROM openjdk:17-jdk-alpine AS build

WORKDIR /app

COPY gradle /app/gradle
COPY gradlew /app/
COPY build.gradle /app/
COPY settings.gradle /app/
COPY src /app/src

RUN chmod +x gradlew

RUN ./gradlew build --no-daemon

FROM openjdk:17-jdk-alpine AS final

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
