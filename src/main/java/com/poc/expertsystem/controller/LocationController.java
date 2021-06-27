package com.poc.expertsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.expertsystem.model.LocationRequest;
import com.poc.expertsystem.model.LocationResults;
import com.poc.expertsystem.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LocationController {

	private final LocationService locationService;
	
	@PostMapping(value = "/location", produces = "application/json")
	public LocationResults location(@RequestBody LocationRequest request) {
		return locationService.getLocation(request);
	}
}