FROM maven:3.8.1-openjdk-11-slim AS builder
COPY . /usr/src/static-code-analysis
WORKDIR /usr/src/static-code-analysis
RUN ./maven-build.sh


FROM sonarqube:10.1.0-community
COPY --from=builder /usr/src/static-code-analysis/target/static-*.jar /opt/sonarqube/extensions/plugins/


