package com.example.demo.service;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.xml.Gpx;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GpsFileHandlerTest {
	
	@Autowired
	GpsFileHandler gpsFileHandler;
	
	/*
	 * Simple test for get gps file content method
	 * It should be better if implement some more test for the potential exception but just leave it for formal project
	 */
	@Test
	public void testGetGpsFileContent() throws FileNotFoundException, IOException {
		Gpx myGpx = gpsFileHandler.getGpsFileContent();
		assertNotNull(myGpx);
	}

}
