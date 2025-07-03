#systax=docker/dockerfile:1

FROM eclipse-temurin:21-alpine

COPY *.jar system-server.jar

EXPOSE 8095

CMD exec java $JAVA_OPTS  -jar system-server.jar