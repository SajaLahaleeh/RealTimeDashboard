// The MetricsAggregator class is responsible for store data in memory using a ConcurrentHashMap.
package com.example.firstImplementation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.firstImplementation.model.AggregatedMetrics;
import com.example.firstImplementation.model.ServerMetrics;
//AggregatedMetrics object will store the comulative totals and count.
@Service
public class MetricsAggregator {

    //In memory Storage
    private final Map<Integer, AggregatedMetrics> aggregatedData = new ConcurrentHashMap<>();    

    // Add new metrics to the aggregator
    public void addMetrics(ServerMetrics metrics){
        aggregatedData.compute(metrics.getServerId(), (id, current) -> {
            if (current == null) {
                current = new AggregatedMetrics(metrics); // initialize with the incoming netrics
            }else {
                current.add(metrics); // update existing metrics
            }
            return current;
        });
    }

    // Retrieve aggregated metrics for a specific server
    public Map<Integer, AggregatedMetrics> getAll() {
        return aggregatedData;
    }
    // Get a snapshot as a list for DB flush or API response
    public List <AggregatedMetrics> snapshot(){
        return new ArrayList<>(aggregatedData.values());
    }

    // Clear all aggregated data
    public void clear() {
        aggregatedData.clear();
    }

}
