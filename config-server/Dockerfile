FROM amazoncorretto:21 AS runner
COPY build/libs/config.jar config.jar

EXPOSE 8888

CMD java -Dspring.profiles.active=docker -Dspring.security.user.password=$CONFIG_USER_SECRET -Dspring.cloud.config.server.git.uri=$CONFIG_REPO -jar config.jar