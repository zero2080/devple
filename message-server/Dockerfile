FROM amazoncorretto:21 AS runner
COPY build/libs/message.jar message.jar

EXPOSE 9999

CMD java -jar -Dspring.rabbitmq.password=$RABBIT_PASSWORD -Dspring.profiles.active=docker message.jar