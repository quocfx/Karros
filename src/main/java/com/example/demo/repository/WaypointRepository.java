package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Waypoint;

@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Integer> {
	Optional<Waypoint> findByIdAndGpsId(int id, int GpsId);
}
