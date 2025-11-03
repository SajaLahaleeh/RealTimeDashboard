package com.example.firstImplementation;

import java.util.HashMap;
import java.util.Map;

class AggregatedData {
    long startTime;
    double cpuSum;
    double memorySum;
    int count;
    double minCpu;
    double maxCpu;
    double minMemory;
    double maxMemory;

    public AggregatedData(double cpu, double memory, long startTime) {
        this.startTime = startTime;
        this.cpuSum = cpu;
        this.memorySum = memory;
        this.count = 1;
        this.minCpu = cpu;
        this.maxCpu = cpu;
        this.minMemory = memory;
        this.maxMemory = memory;
    }
}

public class MetricsAggregator {
    final Map<Integer, AggregatedData> aggregatedMetrics = new HashMap<>();
    final long interval = 15 * 60 * 1000; // 15 min

    public AggregatedData aggregateMetrics(MetricDTO metricReceived) {
        int serverId = metricReceived.getServer_id();
        double cpu = metricReceived.getCpu();
        double memory = metricReceived.getMemory();
        long now = System.currentTimeMillis();

        AggregatedData data = aggregatedMetrics.get(serverId);
        if (data == null) {
            data = new AggregatedData(cpu, memory, now);
            aggregatedMetrics.put(serverId, data);
            return null;
        }

        data.cpuSum += cpu;
        data.memorySum += memory;
        data.count += 1;
        data.minCpu = Math.min(data.minCpu, cpu);
        data.maxCpu = Math.max(data.maxCpu, cpu);
        data.minMemory = Math.min(data.minMemory, memory);
        data.maxMemory = Math.max(data.maxMemory, memory);

        if (now - data.startTime >= interval) {
            AggregatedData result = new AggregatedData(0, 0, now);
            result.cpuSum = data.cpuSum;
            result.memorySum = data.memorySum;
            result.count = data.count;
            result.minCpu = data.minCpu;
            result.maxCpu = data.maxCpu;
            result.minMemory = data.minMemory;
            result.maxMemory = data.maxMemory;

            aggregatedMetrics.put(serverId, new AggregatedData(cpu, memory, now));
            return result;
        }

        return null;
    }
}
