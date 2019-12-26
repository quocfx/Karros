package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Gps;

public interface GpsRepository extends CrudRepository<Gps, Integer> {}