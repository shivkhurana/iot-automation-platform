package com.example.telemetry.service;

import com.example.telemetry.dto.TelemetryStats;
import com.example.telemetry.model.TelemetryPacket;
import com.example.telemetry.repository.TelemetryPacketRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Service
public class TelemetryService {
    private final TelemetryPacketRepository repository;

    public TelemetryService(TelemetryPacketRepository repository) {
        this.repository = repository;
    }

    public TelemetryPacket savePacket(TelemetryPacket packet) {
        if (packet.getTimestamp() == null) {
            packet.setTimestamp(Instant.now());
        }
        return repository.save(packet);
    }

    @Cacheable("latestStats")
    public TelemetryStats getLatestStats() {
        List<TelemetryPacket> recent = repository.findTop100ByOrderByTimestampDesc();
        long count = recent.size();
        double avgTemp = recent.stream()
                .filter(p -> p.getTemperature() != null)
                .mapToDouble(TelemetryPacket::getTemperature)
                .average()
                .orElse(Double.NaN);
        double avgHum = recent.stream()
                .filter(p -> p.getHumidity() != null)
                .mapToDouble(TelemetryPacket::getHumidity)
                .average()
                .orElse(Double.NaN);
        Instant latest = recent.stream()
                .map(TelemetryPacket::getTimestamp)
                .filter(t -> t != null)
                .max(Comparator.naturalOrder())
                .orElse(null);

        return new TelemetryStats(avgTemp, avgHum, count, latest);
    }
}
