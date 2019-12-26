package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Gps;
import com.example.demo.service.GpsService;

@RestController
public class GpsController {
	@Autowired
    GpsService gpsService;
	
	@GetMapping("/gps")
    private List<Gps> getAllGps() {
        return gpsService.getAllGps();
    }

    @GetMapping("/gps/{id}")
    private Gps getGps(@PathVariable("id") int id) {
        return gpsService.getGpsById(id);
    }

    @DeleteMapping("/gps/{id}")
    private void deleteGps(@PathVariable("id") int id) {
    	gpsService.delete(id);
    }

//    @PostMapping("/gps")
    @PostMapping(path = "/gps", consumes = "application/json", produces = "application/json")
    private int saveGps(@RequestBody Gps gps) {
    	gpsService.saveOrUpdate(gps);
        return gps.getId();
    }

}
