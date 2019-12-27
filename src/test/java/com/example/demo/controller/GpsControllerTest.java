package com.example.demo.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Gps;
import com.example.demo.service.GpsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GpsControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
    GpsService gpsService;
	
	private final String url = "http://localhost:9080/gps";
	
	// Mock Gps data
	String mockMetaData = "mock metada";
	String mockWaypoint = "mock waypoint";
	String mockTrack = "mock track";
	
	/*
	 * Test the contenxt is loaded
	*/		
	@Test
	public void contextLoads() {	
	}
	
	/*
	 * Test the request to get all gps
	 * For now, it is implemented to verify the http status only.
	 * It should be implemented to further verify if getAllGps method in gpsService is called when have available time later 
	*/		
	@Test
	public void testGetAllGpsRequest() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockHttpServletRequestBuilder builder = get(url).accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	/*
	 * Test the request to get gps by id
	 * For now, it is implemented to verify the http status only.
	 * It should be implemented to further verify if getGpsById method in gpsService is called when have available time later 
	*/		
	@Test
	public void testGetGpsByIdRequest() throws Exception {
		// Test setup
		// Insert new item to ensure we have at least one  item in db and get its id
		// It is better to use mock data from mock test framework but just leave it for now
//		Gps newGps = new Gps(mockMetaData, mockWaypoint, mockTrack);
//		gpsService.saveOrUpdate(newGps);
//		// Get the latest item
//		List<Gps> myResult = gpsService.getAllGps();
//		assertTrue(myResult.size() > 0);
//		// Get the latest one (could be any item in db)
//		Gps newItem = myResult.get(myResult.size() - 1);
//		int 
		
		
		
		// Main test
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockHttpServletRequestBuilder builder = get(url).accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
