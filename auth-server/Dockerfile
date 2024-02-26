FROM gradle:8-jdk21 AS builder
WORKDIR /app

COPY . .

RUN gradle bootJar

FROM amazoncorretto:21 AS runner
COPY --from=builder /app/build/libs/authenticate.jar authenticate.jar

EXPOSE 8082

CMD java -Dspring.profiles.active=docker -Dspring.cloud.config.password=$CONFIG_USER_SECRET -jar authenticate.jar