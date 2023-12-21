FROM amazoncorretto:21 AS runner
COPY build/libs/authenticate.jar authenticate.jar

EXPOSE 8082

CMD java -Dspring.profiles.active=docker -Dspring.cloud.config.password=$CONFIG_USER_SECRET -jar authenticate.jar