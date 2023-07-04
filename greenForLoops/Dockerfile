FROM maven:3.8.1-openjdk-11-slim AS builder
COPY . /usr/src/green-for-loops
WORKDIR /usr/src/green-for-loops/greenForLoops
RUN ./maven-build.sh


FROM sonarqube:10.1.0-community
COPY --from=builder /usr/src/green-for-loops/target/green-*.jar /opt/sonarqube/extensions/plugins/
