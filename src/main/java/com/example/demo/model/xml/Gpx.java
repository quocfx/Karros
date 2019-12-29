package com.example.demo.model.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

@XmlRootElement
public class Gpx {
	private Metadata metadata;
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Waypoint> wpt = new ArrayList<>();
	private Track trk;

	/**
	 * @return the metadata
	 */
	@XmlElement(name="metadata")
	public Metadata getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the wpt
	 */
	public List<Waypoint> getWpt() {
		return wpt;
	}

	/**
	 * @param wpt the wpt to set
	 */
	public void setWpt(List<Waypoint> wpt) {
		this.wpt = wpt;
	}

	/**
	 * @return the trk
	 */
	public Track getTrk() {
		return trk;
	}

	/**
	 * @param trk the trk to set
	 */
	public void setTrk(Track trk) {
		this.trk = trk;
	}

}
