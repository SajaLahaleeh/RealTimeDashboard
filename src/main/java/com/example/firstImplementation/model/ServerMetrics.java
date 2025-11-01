package com.example.firstImplementation.model;

public class ServerMetrics {
    private String serverId;
    private double cpuUsage;    
    private double memoryUsage;
    private long timestamp;


    public ServerMetrics(String serverId, double cpuUsage, double memoryUsage, long timestamp) {
        this.serverId = serverId;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.timestamp = timestamp;

    }
    public String getServerId() {
        return serverId;
    }
    public double getCpuUsage() {
        return cpuUsage;
    }
    public double getMemoryUsage() {
        return memoryUsage;
    }
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
    public void setMemoryUsage(double memoryUsage){
        this.memoryUsage = memoryUsage;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ServerMetrics [serverId=" + serverId + ", cpuUsage=" + cpuUsage + ", memoryUsage=" + memoryUsage + ", timestamp=" + timestamp + "]";
    }
    
    
}
