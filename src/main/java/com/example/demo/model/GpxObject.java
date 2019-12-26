package com.example.demo.model;

public class GpxObject {
	private String metaData;
	private String wayPoint;
	private String track;
	
	public GpxObject(String metaData, String wayPoint, String track) {
		this.metaData = metaData;
		this.wayPoint = wayPoint;
		this.track = track;
	}
	
	/**
	 * @return the metaData
	 */
	public String getMetaData() {
		return metaData;
	}
	/**
	 * @return the wayPoint
	 */
	public String getWayPoint() {
		return wayPoint;
	}
	/**
	 * @return the track
	 */
	public String getTrack() {
		return track;
	}

}
