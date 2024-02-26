FROM gradle:8-jdk21 AS builder
WORKDIR /app

COPY . .

RUN gradle bootJar

FROM amazoncorretto:21 AS runner

WORKDIR /app
COPY --from=builder /app/build/libs/config.jar config.jar

EXPOSE 8888

CMD java -Dspring.profiles.active=docker -Dspring.security.user.password=$CONFIG_USER_SECRET -Dspring.cloud.config.server.git.uri=$CONFIG_REPO -jar config.jar