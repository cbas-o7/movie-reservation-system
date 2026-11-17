# ==========================================
# ETAPA 1: Construcción (Build)
# ==========================================
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

# .jar ignorando los tests (para mayor velocidad)
RUN mvn package -DskipTests

# ==========================================
# ETAPA 2: Ejecución (Run)
# ==========================================
FROM eclipse-temurin:25-jre

WORKDIR /app

RUN useradd -m appuser
USER appuser

COPY --from=build  /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

