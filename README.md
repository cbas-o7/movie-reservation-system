# Movie Reservation System

[![CI](https://github.com/cbas-o7/movie-reservation-system/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/cbas-o7/movie-reservation-system/actions/workflows/ci.yml)

Sistema full-stack para la gestión y reservación de boletos de cine, estructurado como un monorepo con backend en Java/Spring Boot, base de datos PostgreSQL y un futuro frontend desacoplado.

## Stack tecnológico

* **Backend:** Java 25 (Temurin), Spring Boot, Spring Data JPA, Spring Boot Actuator, Maven Wrapper
* **Base de datos:** PostgreSQL 16 (`postgres:16-alpine`)
* **Testing:** JUnit 5, MockMvc, Testcontainers
* **Infraestructura y CI/CD:** Docker, Docker Compose, GitHub Actions

## Requisitos previos

* [Docker Desktop](https://www.docker.com/products/docker-desktop/) instalado y en ejecución
* [Java 25](https://adoptium.net/) (solo si deseas ejecutar las pruebas o compilar fuera de Docker)
* Git

## Cómo levantar el proyecto

1. Clona el repositorio y entra a la carpeta raíz:
   ```bash
   git clone [https://github.com/cbas-o7/movie-reservation-system.git](https://github.com/cbas-o7/movie-reservation-system.git)
   cd movie-reservation-system

2. Crea tu archivo de variables de entorno a partir de la plantilla:

    ```Bash
    cp .env.example .env
* En Windows PowerShell también funciona cp .env.example .env
* Si usas CMD clásico, usa copy .env.example .env.

3. Construye y levanta los contenedores (API y PostgreSQL):

    ```Bash
    docker compose up --build

4. Verifica que el backend esté respondiendo:

* **Healthcheck:** http://localhost:8080/actuator/health

* **Endpoint de prueba:** http://localhost:8080/api/ping

    Para detener los servicios conservando los datos de la base de datos:

    ```Bash
    docker compose down

## Cómo correr las pruebas
Las pruebas de integración utilizan Testcontainers, por lo que no necesitas tener levantado docker compose, solo debes tener Docker Desktop abierto.

Entra a la carpeta del backend y ejecuta el Maven Wrapper:

* Linux / macOS / Git Bash:

    ```Bash
    cd backend
    ./mvnw verify

* Windows (PowerShell / CMD):

    ```PowerShell
    cd backend
    .\mvnw.cmd verify

Estructura del proyecto

```text
movie-reservation-system/
├── .github/
│   └── workflows/
│       └── ci.yml          # Pipeline de CI (build + tests con Testcontainers)
├── backend/                # API REST en Spring Boot
│   ├── src/
│   ├── Dockerfile          # Build multi-stage para la API
│   ├── mvnw / mvnw.cmd     # Maven Wrapper
│   └── pom.xml
├── frontend/               # Próxima aplicación cliente
├── .env.example            # Plantilla de variables de entorno
└── docker-compose.yaml     # Orquestación local (API + PostgreSQL)
```
## Convención de commits
Este repositorio sigue Conventional Commits:

* feat: nueva funcionalidad
* fix: corrección de errores
* docs: cambios en documentación (como este README)
* test: agregar o corregir pruebas
* ci: cambios en GitHub Actions o pipelines
* chore: tareas de mantenimiento o configuración

## Roadmap

* [x] **Fase 1:** *Setup inicial, Docker, pruebas base y CI*
* [ ] **Fase 2:** *Catálogo*
* [ ] **Fase 3:** *Seguridad y primer despliegue*
* [ ] **Fase 4:** *Reservas y concurrencia*
* [ ] **Fase 5:** *Redis*
* [ ] **Fase 6:** *Frontend*
* [ ] **Fase 7:** *Pulido*