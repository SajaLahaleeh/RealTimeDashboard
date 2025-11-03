package com.example.firstImplementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// ./mvnw test
import static org.junit.jupiter.api.Assertions.*;

class MetricsAggregatorTest {

    private MetricsAggregator aggregator;

    @BeforeEach
    void setUp() {
        aggregator = new MetricsAggregator();
    }

    @Test
    void testAggregateMetricsWithMultipleInputs() {
        int serverId = 1;
        double[] cpuValues = {10, 20, 15, 25, 30};
        double[] memoryValues = {100, 80, 90, 70, 60};

        double expectedCpuSum = 0;
        double expectedMemorySum = 0;
        double expectedMinCpu = Double.MAX_VALUE;
        double expectedMaxCpu = Double.MIN_VALUE;
        double expectedMinMemory = Double.MAX_VALUE;
        double expectedMaxMemory = Double.MIN_VALUE;

        // Send metrics to aggregator
        for (int i = 0; i < cpuValues.length; i++) {
            MetricDTO metric = new MetricDTO();
            metric.setServer_id(serverId);
            metric.setCpu(cpuValues[i]);
            metric.setMemory(memoryValues[i]);

            AggregatedData result = aggregator.aggregateMetrics(metric);

            // Calculate expected values
            expectedCpuSum += cpuValues[i];
            expectedMemorySum += memoryValues[i];
            expectedMinCpu = Math.min(expectedMinCpu, cpuValues[i]);
            expectedMaxCpu = Math.max(expectedMaxCpu, cpuValues[i]);
            expectedMinMemory = Math.min(expectedMinMemory, memoryValues[i]);
            expectedMaxMemory = Math.max(expectedMaxMemory, memoryValues[i]);

            // Aggregation should return null (interval not reached)
            assertNull(result);
        }

        // Access internal state after sending all metrics
        AggregatedData internal = aggregator.aggregatedMetrics.get(serverId);
        assertNotNull(internal);

        // Compute averages
        double CpuAvg = internal.cpuSum / internal.count;
        double ExpCpuAvg = expectedCpuSum / cpuValues.length;
        double MemoryAvg = internal.memorySum / internal.count;
        double ExpMemoryAvg = expectedMemorySum / cpuValues.length;

        // Debug prints
        System.out.printf("expected CPU Sum: %.2f, Internal CPU Sum: %.2f%n", expectedCpuSum, internal.cpuSum);
        System.out.printf("expected Memory Sum: %.2f, Internal Memory Sum: %.2f%n", expectedMemorySum, internal.memorySum);
        System.out.printf("CPU Avg: %.2f, Expected CPU Avg: %.2f%n", CpuAvg, ExpCpuAvg);
        System.out.printf("Memory Avg: %.2f, Expected Memory Avg: %.2f%n", MemoryAvg, ExpMemoryAvg);

        // Assertions
        assertEquals(expectedCpuSum, internal.cpuSum, 0.001);
        assertEquals(expectedMemorySum, internal.memorySum, 0.001);
        assertEquals(expectedMinCpu, internal.minCpu, 0.001);
        assertEquals(expectedMaxCpu, internal.maxCpu, 0.001);
        assertEquals(expectedMinMemory, internal.minMemory, 0.001);
        assertEquals(expectedMaxMemory, internal.maxMemory, 0.001);
        assertEquals(cpuValues.length, internal.count);
        assertEquals(ExpCpuAvg, CpuAvg, 0.001);
        assertEquals(ExpMemoryAvg, MemoryAvg, 0.001);
    }
}
