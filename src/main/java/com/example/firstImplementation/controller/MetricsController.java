//The Server send metrics to this controller, which receives and processes them, then pass the data to the MetricsAggregator service for aggregation.

package com.example.firstImplementation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstImplementation.model.AggregatedMetrics;
import com.example.firstImplementation.model.ServerMetrics;
import com.example.firstImplementation.service.MetricsAggregator;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final MetricsAggregator aggregator;

    public MetricsController(MetricsAggregator aggregator) {
        this.aggregator = aggregator;
    }

// Post the metrics from server to aggregator
@PostMapping
public Mono<String> receiveMetrics(@RequestBody ServerMetrics metrics) {
    aggregator.addMetrics(metrics);
    return Mono.just("Metrics received successfully");
}
// Get all aggregated metrics
// @GetMapping("/aggregated")
// public Mono<Map<String, AggregatedMetrics>> getAggregated() {
//     return Mono.just(aggregator.getAll());
// }

// Get all aggregated metrics with snapshot we use snapshot to get our metrics on in-memory aggrigation
@GetMapping("/aggregated")
public Mono<List<AggregatedMetrics>> getAggregated() {
    return Mono.just(aggregator.snapshot());
}


// Get aggregated metrics for a specific server
@GetMapping("/aggregated/{serverId}")
public Mono<AggregatedMetrics> getAggregatedByServerId(@PathVariable String serverId){
    return Mono.justOrEmpty(aggregator.getAll().get(serverId));
}

}


//This work without Aggregation
// @PostMapping
// public Mono<String> receiveMetrics(@RequestBody ServerMetrics metrics) {
//     System.out.println("Received metrics from " + metrics.getServerId());
//     return Mono.just("OK");
// }

// @GetMapping("/aggregated")
// public Mono<String> getAggregated() {
//     return Mono.just("working");
// }

// This work without getAllAggregated

