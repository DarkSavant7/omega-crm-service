FROM bellsoft/liberica-openjdk-alpine:11.0.12-7 as builder
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests


FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine as production
LABEL maintainer="Alex Grigorev persian89g2@ya.ru"
VOLUME /tmp
WORKDIR /app
#
COPY --from=builder /app/target/dist/*jar /app/
RUN mkdir /app/files
RUN mkdir /app/log
ENV JAVA_TOOL_OPTIONS=""

ENTRYPOINT ["sh", "-c", "java --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED ${JAVA_TOOL_OPTIONS} -jar omega-crm.jar"]
