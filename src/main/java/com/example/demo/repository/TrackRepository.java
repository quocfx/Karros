package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Track;

@Repository
public interface TrackRepository extends CrudRepository<Track, Integer> {
	List<Track> findTop10ByOrderByTimeDesc();
}
