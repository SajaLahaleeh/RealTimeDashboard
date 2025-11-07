package com.example.firstImplementation.service;

import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.firstImplementation.model.AggregatedMetrics;
import com.example.firstImplementation.model.ServerEntity;
import com.example.firstImplementation.model.ServerMetricsEntity;
import com.example.firstImplementation.repository.ServerMetricsRepository;
import com.example.firstImplementation.repository.ServerRepository;

@Service
public class MetricsPersistenceService {

    private final MetricsAggregator aggregator;
    private final ServerRepository serverRepository;
    private final ServerMetricsRepository metricsRepository;

    public  MetricsPersistenceService(MetricsAggregator aggregator,ServerRepository serverRepository,ServerMetricsRepository metricsRepository){
        this.aggregator = aggregator;
        this.serverRepository = serverRepository;
        this.metricsRepository = metricsRepository;
    }

// run every 15 min to flush aggregated metrics to DB 
// 15*60*1000 = 900000 ms
@Scheduled(fixedRate = 900000)
public void flushAggregatedMetricsToDB(){
    Map<Integer, AggregatedMetrics> snapshot = aggregator.getAll();

    snapshot.forEach((serverId,metrics)-> {
        // Here we would Fetch server details from DB, we assume server exists, if not we create it
        ServerEntity server = serverRepository.findById(serverId).
        orElseGet(() -> serverRepository.save(new ServerEntity()));
        
        //Create ServerMetricsEntity and save to DB
        ServerMetricsEntity metricsEntity = new ServerMetricsEntity(
            server,
            metrics.getAverageCpuUsage(),
            metrics.getAverageMemoryUsage(),
            System.currentTimeMillis()
        );
        metricsRepository.save(metricsEntity);

        System.out.printf("Saving serverId=%s | avgCPU=%.2f | avgMem=%.2f%n" ,
        serverId,
        metrics.getAverageCpuUsage(),
        metrics.getAverageMemoryUsage()
        );
        //For now, just print the data (Showq will store it in DB later)
        
    });
}

}
