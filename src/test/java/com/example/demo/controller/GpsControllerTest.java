package com.example.demo.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@SpringBootTest
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
		// Main test for add new item REST
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Gps newGps = new Gps(mockMetaData, mockWaypoint, mockTrack);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(newGps);			
		MockHttpServletRequestBuilder builder = post(url)
				.content(jsonStr)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
		// Get the latest gps item after previous call
		List<Gps> myResult = gpsService.getAllGps();
		assertTrue(myResult.size() > 0);
		// Get the latest one (could be any item in db)
		Gps newItem = myResult.get(myResult.size() - 1);
		int newId = newItem.getId();
		
		// Main test for get item by Id REST		
		String myUrl = url + "/" + newId;
		builder = get(myUrl).accept(MediaType.APPLICATION_JSON);
		ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		// TODO: The result should be verified also but let's leave it for now
	}
}
