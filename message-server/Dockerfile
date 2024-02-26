FROM gradle:8-jdk21 AS builder
WORKDIR /app

COPY . .

RUN gradle bootJar

FROM amazoncorretto:21 AS runner
COPY --from=builder /app/build/libs/message.jar message.jar

EXPOSE 9999

CMD java -jar -Dspring.rabbitmq.password=$RABBIT_PASSWORD -Dspring.profiles.active=docker message.jar