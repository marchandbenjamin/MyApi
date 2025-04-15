FROM maven:3.9.4-eclipse-temurin-21

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080 5005

CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]
