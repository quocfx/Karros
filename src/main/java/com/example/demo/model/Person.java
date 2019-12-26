package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String emailId;
    
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
