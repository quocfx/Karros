package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Gps;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GpsServiceTest {
	@Autowired
    GpsService gpsService;
	
	/*
	 * Test getAllService, insert new item to service, and find by service id
	 */
	@Test
	public void testGetAllInsertFind() {
		// The default gps list is an empty list
		List<Gps> myResult = gpsService.getAllGps();
		assertTrue(myResult.size() == 0);
		
		// Prepare a mock item and insert it
		String mockMetaData = "mock metada";
		String mockWaypoint = "mock waypoint";
		String mockTrack = "mock track";
		Gps newGps = new Gps(mockMetaData, mockWaypoint, mockTrack);
		gpsService.saveOrUpdate(newGps);
		
		// Ensure the new item is added
		myResult = gpsService.getAllGps();
		assertTrue(myResult.size() == 1);
		Gps newItem = myResult.get(0);
		assertEquals(mockMetaData, newItem.getMetadata());
		assertEquals(mockWaypoint, newItem.getWaypoint());
		assertEquals(mockTrack, newItem.getTrack());
		
		// Get new item id and test search by id
		int newId = newItem.getId();
		Gps resultItem = gpsService.getGpsById(newId);
		assertEquals(mockMetaData, resultItem.getMetadata());
		assertEquals(mockWaypoint, resultItem.getWaypoint());
		assertEquals(mockTrack, resultItem.getTrack());
	}

}
