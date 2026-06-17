# IoT Telemetry Platform (Sample)

Simple Spring Boot application to ingest telemetry packets and return cached statistics.

Build and run:

```bash
mvn package
mvn spring-boot:run
```

Endpoints:
- `POST /api/telemetry` - ingest a JSON `TelemetryPacket`
- `GET /api/telemetry/stats` - retrieve cached stats

H2 console available at `/h2-console` when running locally.
