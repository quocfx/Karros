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
	 * It will be better if use some mock test framework here but just leave it for formal project
	 */
	@Test
	public void testGetAllInsertFind() {
		// The default gps list is an empty list
		List<Gps> myResult = gpsService.getAllGps();
		assertTrue(myResult.size() == 0);
		
		// Prepare a test item and insert it
		String testName = "test name";
		String testDesc = "test desc";
		String testAuthor = "test author";
		String testLinkUrl = "test link URL";
		String testLinkText = "test link text";
		Gps newGps = new Gps();
		newGps.setName(testName);
		newGps.setDesc(testDesc);
		newGps.setAuthor(testAuthor);
		newGps.setLinkUrl(testLinkUrl);
		newGps.setLinkText(testLinkText);
		gpsService.saveOrUpdate(newGps);
		
		// Ensure the new item is added
		myResult = gpsService.getAllGps();
		assertTrue(myResult.size() == 1);
		Gps newItem = myResult.get(0);
		assertEquals(testName, newItem.getName());
		assertEquals(testDesc, newItem.getDesc());
		assertEquals(testAuthor, newItem.getAuthor());
		
		// Get new item id and test search by id
		int newId = newItem.getId();
		Gps resultItem = gpsService.getGpsById(newId);
		assertEquals(testName, resultItem.getName());
		assertEquals(testDesc, resultItem.getDesc());
		assertEquals(testAuthor, resultItem.getAuthor());
		assertEquals(testLinkUrl, resultItem.getLinkUrl());
		assertEquals(testLinkText, resultItem.getLinkText());
	}

}
