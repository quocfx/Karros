package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gps;
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
		gpsRepository.save(gps);
    }
	
	public void delete(int id) {
		gpsRepository.deleteById(id);
    }
}
