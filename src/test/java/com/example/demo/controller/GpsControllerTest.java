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
	
	private final String URL = "http://localhost:9080/gps";
	
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
		MockHttpServletRequestBuilder builder = get(URL).accept(MediaType.APPLICATION_JSON);
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
		// Prepare a test item and insert it
		// TODO: Duplicate code of GpsServiceTest class. Should be provided by an utility class for test Gps item
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
		
		// Get the latest gps item after previous call
		List<Gps> myResult = gpsService.getAllGps();
		assertTrue(myResult.size() > 0);
		// Get the latest one (could be any item in db)
		Gps newItem = myResult.get(myResult.size() - 1);
		int newId = newItem.getId();
		
		// Main test for get item by Id REST		
		String myUrl = URL + "/" + newId;
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockHttpServletRequestBuilder builder = get(myUrl).accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		// TODO: The result should be verified also but let's leave it for now
	}
}
