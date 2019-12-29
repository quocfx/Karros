package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Waypoint {
	@Id
    @GeneratedValue
    private int id;
	
	private String name;
	private String sym;
	private String lat;
	private String lon;
	
	@ManyToOne (fetch = FetchType.LAZY, optional = false)
	@JoinColumn (name = "gps_id", nullable = false)
	@JsonIgnore
	private Gps gps;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
