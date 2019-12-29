package com.example.demo.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TrackPoint {
	@JacksonXmlProperty(isAttribute = true)
	private String lat;
	@JacksonXmlProperty(isAttribute = true)
	private String lon;
	private String ele;
	private String time;
	
	public TrackPoint() {
	}

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * @return the ele
	 */
	public String getEle() {
		return ele;
	}

	/**
	 * @param ele the ele to set
	 */
	public void setEle(String ele) {
		this.ele = ele;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

}
