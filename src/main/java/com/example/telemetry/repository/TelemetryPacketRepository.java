package com.example.telemetry.repository;

import com.example.telemetry.model.TelemetryPacket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TelemetryPacketRepository extends JpaRepository<TelemetryPacket, Long> {
    List<TelemetryPacket> findTop100ByOrderByTimestampDesc();
}
