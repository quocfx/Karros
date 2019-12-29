package com.example.demo.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Waypoint {
	private String name;
	private String sym;
	@JacksonXmlProperty(isAttribute = true)
	private String lat;
	@JacksonXmlProperty(isAttribute = true)
	private String lon;
	
	public Waypoint() {
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sym
	 */
	public String getSym() {
		return sym;
	}
	/**
	 * @param sym the sym to set
	 */
	public void setSym(String sym) {
		this.sym = sym;
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
}
