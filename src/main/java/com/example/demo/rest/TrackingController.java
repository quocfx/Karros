package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GpxObject;

@RestController
public class TrackingController {
	
	@RequestMapping("/gpx/latest-tracks")
	public List<GpxObject> getLatestTracks() {
		List<GpxObject> resultList = new ArrayList<GpxObject>();
		resultList.add(new GpxObject("meta 01", "way 01", "track 01"));
		resultList.add(new GpxObject("meta 02", "way 02", "track 02"));
		resultList.add(new GpxObject("meta 03", "way 03", "track 03"));
		return resultList;
	}

}
