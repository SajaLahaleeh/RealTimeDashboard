package com.example.firstImplementation.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servers")
public class ServerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverId;

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServerMetricsEntity> metrics;

    public ServerEntity() {}

    public int getServerId() {
        return serverId;
    }     
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
    public List<ServerMetricsEntity> getMetrics() {
        return metrics;
    }
    public void setMetrics(List<ServerMetricsEntity> metrics) {
        this.metrics = metrics;
    }
    
}
