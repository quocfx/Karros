package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Track {
	@Id
    @GeneratedValue
    private int id;
	
	private String lat;
	private String lon;
	private String ele;
	// It should be Date but just leave it for now.
	private String time;
	
	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@JoinColumn (name = "gps_id", nullable = false)
	@JsonIgnore
	private Gps gps;
	
	public Track() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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

	/**
	 * @return the gps
	 */
	public Gps getGps() {
		return gps;
	}

	/**
	 * @param gps the gps to set
	 */
	public void setGps(Gps gps) {
		this.gps = gps;
	}
}
