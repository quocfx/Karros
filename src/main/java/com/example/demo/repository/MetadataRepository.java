package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Metadata;

@Repository
public interface MetadataRepository extends CrudRepository<Metadata, Integer> {
	Optional<Metadata> findByIdAndGpsId(int id, int GpsId);
}
