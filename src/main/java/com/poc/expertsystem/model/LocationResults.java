package com.poc.expertsystem.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LocationResults {
	private String decision;
	private List<String> facts = new ArrayList<>();
	
	public void addFact(String fact) {
		facts.add(fact);
	}

 }
