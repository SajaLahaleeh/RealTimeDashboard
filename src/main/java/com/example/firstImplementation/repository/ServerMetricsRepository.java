package com.example.firstImplementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstImplementation.model.ServerMetricsEntity;

public interface ServerMetricsRepository  extends JpaRepository<ServerMetricsEntity, Integer> {
 
}
