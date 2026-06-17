package com.example.telemetry.dto;

import java.time.Instant;

public class TelemetryStats {
    private double averageTemperature;
    private double averageHumidity;
    private long totalCount;
    private Instant latestTimestamp;

    public TelemetryStats() {
    }

    public TelemetryStats(double averageTemperature, double averageHumidity, long totalCount, Instant latestTimestamp) {
        this.averageTemperature = averageTemperature;
        this.averageHumidity = averageHumidity;
        this.totalCount = totalCount;
        this.latestTimestamp = latestTimestamp;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(double averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Instant getLatestTimestamp() {
        return latestTimestamp;
    }

    public void setLatestTimestamp(Instant latestTimestamp) {
        this.latestTimestamp = latestTimestamp;
    }
}
