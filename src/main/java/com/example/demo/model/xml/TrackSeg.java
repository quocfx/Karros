package com.example.demo.model.xml;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class TrackSeg {
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<TrackPoint> trkpt = new ArrayList<>();
	
	public TrackSeg() {
	}

	/**
	 * @return the trkpt
	 */
	public List<TrackPoint> getTrkpt() {
		return trkpt;
	}

	/**
	 * @param trkpt the trkpt to set
	 */
	public void setTrkpt(List<TrackPoint> trkpt) {
		this.trkpt = trkpt;
	}

}
