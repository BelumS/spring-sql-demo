FROM openjdk:11
MAINTAINER 'Bel Sahn'
EXPOSE 8080

ARG HOME=/app

ENV SERVER_PORT=8080
ENV logFilePath=${HOME}/tmp/logs
ENV ENV=default

WORKDIR ${HOME}
COPY . ${HOME}

RUN ./gradlew clean build -x test --refresh-dependencies
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-war","/app/build/libs/spring-sql-gradle-producer-0.0.1-SNAPSHOT.war"]
