package com.example.firstImplementation;

public class MetricDTO {
    private int server_id;
    private double cpu;
    private double memory;

    public int getServer_id() { return server_id; }
    public void setServer_id(int server_id) { this.server_id = server_id; }
    public double getCpu() { return cpu; }
    public void setCpu(double cpu) { this.cpu = cpu; }
    public double getMemory() { return memory; }
    public void setMemory(double memory) { this.memory = memory; }
}
