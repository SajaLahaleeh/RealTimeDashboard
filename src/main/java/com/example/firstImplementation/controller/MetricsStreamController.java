package com.example.firstImplementation.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstImplementation.model.AggregatedMetrics;
import com.example.firstImplementation.service.MetricsAggregator;

import java.time.Duration;
import reactor.core.publisher.Flux;

@RestController
public class MetricsStreamController {

    private final MetricsAggregator aggregator;

    public MetricsStreamController(MetricsAggregator aggregator){
        this.aggregator = aggregator;
    }

    //SEE endpoint: push updated aggregated metrics to clients in real-time evry 1 second
    @GetMapping(value = "/metrics/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String,AggregatedMetrics>> stramAggregatedMetrics(){
        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> aggregator.getAll());
    }
    
}
