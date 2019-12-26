package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {}
