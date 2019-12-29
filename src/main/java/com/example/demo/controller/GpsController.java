package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Gps;
import com.example.demo.service.GpsFileHandler;
import com.example.demo.service.GpsService;

@RestController
public class GpsController {
	@Autowired
    GpsService gpsService;
	
	@Autowired
    GpsFileHandler gpsFileHandler;
	
	@GetMapping("/gps")
    private List<Gps> getAllGps() {
        return gpsService.getAllGps();
    }

    @GetMapping("/gps/{id}")
    private Gps getGps(@PathVariable("id") int id) {
        return gpsService.getGpsById(id);
    }
}
