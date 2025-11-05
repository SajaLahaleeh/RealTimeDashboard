package com.example.firstImplementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstImplementation.model.ServerEntity;

public interface ServerRepository extends JpaRepository<ServerEntity,Integer>{

}
