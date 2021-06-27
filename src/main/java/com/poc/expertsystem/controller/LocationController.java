package com.poc.expertsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.expertsystem.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LocationController {

	private final LocationService locationService;
	
	@GetMapping(value = "/location", produces = "application/json")
	public void location() {
		locationService.getLocation();
	}
}