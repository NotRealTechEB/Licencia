FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY dgac.licencia/mvnw dgac.licencia/pom.xml ./
COPY dgac.licencia/src ./src
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests -B

FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8085

# Railway inyecta la variable PORT; si no existe, cae a 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
