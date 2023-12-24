FROM amazoncorretto:21 AS runner
COPY build/libs/gateway.jar gateway.jar

EXPOSE 8080

CMD java -Dspring.profiles.active=docker -Dspring.cloud.config.password=$CONFIG_USER_SECRET -jar gateway.jar