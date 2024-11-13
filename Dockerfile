FROM eclipse-temurin:17-jre

WORKDIR /ac2_ca

COPY target/ac2_ca-0.0.1-SNAPSHOT.jar /ac2_ca/ac2_ca-0.0.1-SNAPSHOT.jar
EXPOSE 8585

CMD ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-Dserver.port=8585", "-jar", "ac2_ca-0.0.1-SNAPSHOT.jar"]