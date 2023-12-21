FROM amazoncorretto:21 AS runner
COPY build/libs/gateway.jar gateway.jar

EXPOSE 8080

CMD java -Dspring.profiles.active=docker -DAPI_HOST=$API_HOST -DCONFIG_USER_SECRET=$CONFIG_USER_SECRET -DMESSAGE_HOST=$MESSAGE_HOST -jar gateway.jar