# Metrics Demo

Spring Boot demo application showcasing metrics collection and monitoring using Micrometer with Prometheus integration.

[![License](https://img.shields.io/badge/MIT%20-blue.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-orange.svg)](pom.xml)
[![Build](https://img.shields.io/badge/build-Maven-brightgreen.svg)](https://maven.apache.org/)

---

## Overview

This project demonstrates how to instrument a Spring Boot application with production-ready metrics using Micrometer and Prometheus. It tracks transaction processing latency, transaction counts by type, and active user sessions through custom metrics and counters. The application exposes metrics via the Actuator endpoints for real-time monitoring and analysis.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 3.5.11 |
| Language | Java 21 |
| Metrics | Micrometer, Prometheus |
| Build System | Maven |
| Utilities | Lombok |
| Testing | JUnit 5 |

## Installation

Clone the repository:

```bash
git clone <repository-url>
cd metrics_demo
```

Build the project:

```bash
mvn clean install
```

Or use the Maven wrapper:

```bash
./mvnw clean install
```

## Usage

Start the application:

```bash
mvn spring-boot:run
```

Or using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Access the endpoints:

Process a transaction:

```bash
curl -X POST http://localhost:8080/api/transactions/CREDIT
```

Open a session:

```bash
curl -X POST http://localhost:8080/api/transactions/sessions/open
```

View metrics:

```bash
curl http://localhost:8080/actuator/metrics
curl http://localhost:8080/actuator/prometheus
```

## License

MIT 2.0

---

Made by @isra_dev
