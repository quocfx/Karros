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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
