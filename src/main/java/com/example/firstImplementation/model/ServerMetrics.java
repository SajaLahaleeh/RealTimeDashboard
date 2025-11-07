package com.example.firstImplementation.model;

public class ServerMetrics {
    private int metricsId;
    private int serverId;
    private double cpuUsage;    
    private double memoryUsage;
    private long timestamp;


    public ServerMetrics(int metricsId,int serverId, double cpuUsage, double memoryUsage, long timestamp) {
        this.metricsId = metricsId;
        this.serverId = serverId;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.timestamp = timestamp;

    }
    public int getMetricsId() {
        return metricsId;
    }
    public void setMetricsId(int metricsId){
        this.metricsId = metricsId;
    }
    public int getServerId() {
        return serverId;
    }
    public double getCpuUsage() {
        return cpuUsage;
    }
    public double getMemoryUsage() {
        return memoryUsage;
    }
    public void setServerId(int serverId) {
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
        return "ServerMetrics [metricsId=" + metricsId +", serverId=" + serverId + ", cpuUsage=" + cpuUsage + ", memoryUsage=" + memoryUsage + ", timestamp=" + timestamp + "]";
    }
    
    
}
