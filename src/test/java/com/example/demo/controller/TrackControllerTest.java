package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private final String URL = "http://localhost:9080/tracks";
	
	/*
	 * Test the request to get recent tracks
	 * For now, it is implemented to verify the http status only.
	 * TODO: It should be implemented to further verify if findTop10ByOrderByTimeDesc method in trackRepository is called when have available time later 
	*/		
	@Test
	public void testGetRecentTracks() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockHttpServletRequestBuilder builder = get(URL).accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mockMvc.perform(builder);
		ra.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
