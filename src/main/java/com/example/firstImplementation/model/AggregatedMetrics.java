package com.example.firstImplementation.model;

public class AggregatedMetrics {
    private int serverId;
    private double totalCpuUsage;
    private double totalMemoryUsage;
    private int count;
    private long lastUpdated;

    public AggregatedMetrics(ServerMetrics metrics) {
        this.serverId = metrics.getServerId();
        this.totalCpuUsage = metrics.getCpuUsage();
        this.totalMemoryUsage = metrics.getMemoryUsage();
        this.count = 1;
        this.lastUpdated = metrics.getTimestamp();
    }

    //Empty  constructor for initialization
    public AggregatedMetrics() {
        this.totalCpuUsage = 0;
        this.totalMemoryUsage = 0;
        this.count = 0;
        this.lastUpdated = System.currentTimeMillis();
    }
    // Add new metrics to the aggregation
    public void add(ServerMetrics metrics) {
        this.totalCpuUsage += metrics.getCpuUsage();
        this.totalMemoryUsage += metrics.getMemoryUsage();
        this.count++;
        this.lastUpdated = Math.max(this.lastUpdated,metrics.getTimestamp());
    }
    // Merg metrcs with another AggregatedMetrics object
    public void merge(AggregatedMetrics other) {
        this.totalCpuUsage += other.totalCpuUsage;
        this.totalMemoryUsage += other.totalMemoryUsage;
        this.count += other.count;
        this.lastUpdated = Math.max(this.lastUpdated, other.lastUpdated);
    }
    // Average calculations
    public double getAverageCpuUsage() {
        return count == 0 ? 0 : totalCpuUsage / count;
    }

    public double getAverageMemoryUsage() {
        return count == 0 ? 0 : totalMemoryUsage / count;
    }

    public int getServerId() {
        return serverId;
    }
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }   
    public long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "AggregatedMetrics [serverId=" + serverId +
               ", averageCpuUsage=" + getAverageCpuUsage() +
               ", averageMemoryUsage=" + getAverageMemoryUsage() +
               ", count=" + count +
               ", lastUpdated=" + lastUpdated + "]";
    }


}
