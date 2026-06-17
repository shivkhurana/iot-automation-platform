package com.example.telemetry.controller;

import com.example.telemetry.dto.TelemetryStats;
import com.example.telemetry.model.TelemetryPacket;
import com.example.telemetry.service.TelemetryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    private final TelemetryService service;

    public TelemetryController(TelemetryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> ingest(@Valid @RequestBody TelemetryPacket packet) {
        TelemetryPacket saved = service.savePacket(packet);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/stats")
    public ResponseEntity<TelemetryStats> stats() {
        TelemetryStats stats = service.getLatestStats();
        return ResponseEntity.ok(stats);
    }
}
