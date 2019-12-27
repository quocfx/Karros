package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gps;
import com.example.demo.model.Metadata;
import com.example.demo.repository.GpsRepository;

@Service
public class GpsService {
	@Autowired
	GpsRepository gpsRepository;
	
	public List<Gps> getAllGps() {
        List<Gps> gpsList = new ArrayList<Gps>();
        gpsRepository.findAll().forEach(gps -> gpsList.add(gps));
        return gpsList;
    }

    public Gps getGpsById(int id) {
        return gpsRepository.findById(id).get();
    }
	
	public void saveOrUpdate(Gps gps) {
//		String mockMetaData = "mock metada";
//		String mockWaypoint = "mock waypoint";
//		String mockTrack = "mock track";
//		Gps newGps = new Gps(mockMetaData, mockWaypoint, mockTrack);
		
//		Metadata metadata = new Metadata();
//		metadata.setName("my meta name");
//		metadata.setGps(newGps);
//		
//		newGps.getMetadata()
		
		
		gps.setCreatedDate(new Date());
		gpsRepository.save(gps);
    }
	
	public void delete(int id) {
		gpsRepository.deleteById(id);
    }
}
