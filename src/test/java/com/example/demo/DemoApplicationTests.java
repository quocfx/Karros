package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.example.demo.controller.GpsController;
import com.example.demo.model.Gps;
import com.example.demo.service.GpsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
    GpsService gpsService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	String url = "http://localhost:9080/gps";

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testCase01() {
		List<Gps> myResult = gpsService.getAllGps();
		assertTrue(myResult.size() == 0);
	}
	
	@Test
	public void testCase02() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockHttpServletRequestBuilder builder = get(url).accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
