package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Track;
import com.example.demo.repository.TrackRepository;

@RestController
public class TrackController {
	@Autowired
	TrackRepository trackRepository;
	
	@GetMapping("/tracks")
    private List<Track> getRecentTracks() {
        return trackRepository.findTop10ByOrderByTimeDesc();
    }

}
