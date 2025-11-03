package com.example.firstImplementation.service;

import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.firstImplementation.model.AggregatedMetrics;

@Service
public class MetricsPersistenceService {

    private final MetricsAggregator aggregator;

    public  MetricsPersistenceService(MetricsAggregator aggregator){
        this.aggregator = aggregator;
    }

// run every 15 min to flush aggregated metrics to DB 
// 15*60*1000 = 900000 ms
@Scheduled(fixedRate = 900000)
public void flushAggregatedMetricsToDB(){
    Map<Integer, AggregatedMetrics> snapshot = aggregator.getAll();

    snapshot.forEach((serverId,metrics)-> {
        System.out.printf("Saving serverId=%s | avgCPU=%.2f | avgMem=%.2f%n" ,
        serverId,
        metrics.getAverageCpuUsage(),
        metrics.getAverageMemoryUsage()
        );
        //For now, just print the data (Showq will store it in DB later)
        
    });
}

}
