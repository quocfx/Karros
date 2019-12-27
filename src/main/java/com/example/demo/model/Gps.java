package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gps {
	@Id
    @GeneratedValue
    private int id;
    private String metadata;
	private String waypoint;
    private String track;
    
    /**
	 * Default constructor for Gps
	 */
    public Gps() {
	}
    
    /**
	 * Constructor for Gps
	 */
    public Gps(String metadata, String waypoint, String track) {
		this.metadata = metadata;
		this.waypoint = waypoint;
		this.track = track;
	}
    
    /**
	 * @return the metadata
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the waypoint
	 */
	public String getWaypoint() {
		return waypoint;
	}

	/**
	 * @param waypoint the waypoint to set
	 */
	public void setWaypoint(String waypoint) {
		this.waypoint = waypoint;
	}

	/**
	 * @return the track
	 */
	public String getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(String track) {
		this.track = track;
	}
    
    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
