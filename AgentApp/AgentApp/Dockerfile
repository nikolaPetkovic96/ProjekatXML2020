FROM maven:slim as build
WORKDIR /app
COPY pom.xml /app/
RUN mvn dependency:go-offline
COPY src /app/src/
RUN mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V -e

FROM java:jre-alpine
ARG port=8080
ENV APP_PORT=${port}
WORKDIR /home/usr/app
COPY --from=build /app/target/AgentApp-0.0.1-SNAPSHOT.jar /home/usr/app/AgentApp-0.0.1-SNAPSHOT.jar
EXPOSE $port
CMD ["java", "-jar", "/home/usr/app/AgentApp-0.0.1-SNAPSHOT.jar"]
