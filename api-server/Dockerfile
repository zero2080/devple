FROM amazoncorretto:21 AS runner
COPY build/libs/board.jar board.jar

EXPOSE 8081

CMD java -Dspring.profiles.active=docker -Dspring.cloud.config.password=$CONFIG_USER_SECRET -jar board.jar