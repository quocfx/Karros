package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Gps;
import com.example.demo.model.Track;
import com.example.demo.model.Waypoint;
import com.example.demo.model.xml.Gpx;
import com.example.demo.model.xml.TrackPoint;
import com.example.demo.service.FileService;
import com.example.demo.service.GpsFileHandler;
import com.example.demo.service.GpsService;

@Controller
public class FileController {

    @Autowired
    FileService fileService;
    
    @Autowired
    GpsService gpsService;
	
	@Autowired
    GpsFileHandler gpsFileHandler;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws FileNotFoundException, IOException {
        fileService.uploadFile(file);
        
        // TODO:This logic should not be here. Could be put in the service or elsewhere
		Gpx myGpx = gpsFileHandler.getGpsFileContent();
		if (myGpx != null) {
			// Init Gps object and copy values from gps file content
			Gps myGps = new Gps();
			myGps.setName(myGpx.getMetadata().getName());
			myGps.setDesc(myGpx.getMetadata().getDesc());
			myGps.setAuthor(myGpx.getMetadata().getAuthor());
			myGps.setLinkUrl(myGpx.getMetadata().getLink().getHref());
			myGps.setLinkText(myGpx.getMetadata().getLink().getText());
			
			// Add waypoint values
			List<Waypoint> myWaypoints = new ArrayList<Waypoint>();
			// TODO: It is somewhat confusing because there are 2 different objects using same class name Waypoint. It should be changed later
			for (com.example.demo.model.xml.Waypoint tempWpXML: myGpx.getWpt()) {
				Waypoint tempWp = new Waypoint();
				tempWp.setName(tempWpXML.getName());
				tempWp.setSym(tempWpXML.getSym());
				tempWp.setLat(tempWpXML.getLat());
				tempWp.setLon(tempWpXML.getLon());
				tempWp.setGps(myGps);
				myWaypoints.add(tempWp);
			}
			
			// Add track value
			List<Track> myTracks = new ArrayList<Track>();
			for (TrackPoint tempTrackpoint: myGpx.getTrk().getTrkseg().getTrkpt()) {
				Track tempTrack = new Track();
				tempTrack.setLat(tempTrackpoint.getLat());
				tempTrack.setLon(tempTrackpoint.getLon());
				tempTrack.setEle(tempTrackpoint.getEle());
				tempTrack.setTime(tempTrackpoint.getTime());
				tempTrack.setGps(myGps);
				myTracks.add(tempTrack);
			}
			myGps.setWaypoints(myWaypoints);
			myGps.setTracks(myTracks);
			gpsService.saveOrUpdate(myGps);
		}

        redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}
