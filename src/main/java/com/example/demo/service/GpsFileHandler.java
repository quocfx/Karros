package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.example.demo.model.xml.Gpx;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class GpsFileHandler {
	// TODO: The hard code file path is ugly
	public static final String GPS_FILE_PATH = "upload/temp.gpx";
	
	public Gpx getGpsFileContent() throws FileNotFoundException, IOException {
		File file = new File(GPS_FILE_PATH);
    	if (file.exists() == true) {
    		XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	    String xmlContent = inputStreamToString(new FileInputStream(file));
    	    Gpx myObj = xmlMapper.readValue(xmlContent, Gpx.class);
    		return myObj;
    	} else {
    		return null;
    	}
	}
	
	private String inputStreamToString(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    br.close();
	    return sb.toString();
	}
}