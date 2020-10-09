FROM openjdk:8-jdk-slim
COPY "./target/app-0.0.1-SNAPSHOT.jar" "appbcp.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","appbcp.jar"]