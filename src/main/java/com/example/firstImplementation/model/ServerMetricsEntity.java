package com.example.firstImplementation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "metrics")
public class ServerMetricsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int metricsId;

    @ManyToOne
    @JoinColumn(name = "server_id", referencedColumnName = "serverId")
    private ServerEntity server;

    private double cpuUsage;
    private double memoryUsage;

    @Column(name = "\"timestamp\"")
    private long timestamp;

    public ServerMetricsEntity() {}

    public ServerMetricsEntity(ServerEntity server, double cpuUsage, double memoryUsage, long timestamp){
        this.server = server;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.timestamp = timestamp;
    }

    public int getMetricsId() {
        return metricsId;
    }
    public void setMetricsId(int metricsId) {
        this.metricsId = metricsId;
    }
    public ServerEntity getServer() {
        return server;
    }
    public void setServer(ServerEntity server) {
        this.server = server;
    }
    public double getCpuUsage() {
        return cpuUsage;
    }
    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
    public double getMemoryUsage() {
        return memoryUsage;
    }
    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }



}
