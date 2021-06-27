package com.poc.expertsystem.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LocationRequest {
	private Location location;
	private List<Location> facts = new ArrayList<>();
}
