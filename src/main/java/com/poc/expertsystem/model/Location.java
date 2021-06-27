package com.poc.expertsystem.model;

import org.kie.api.definition.type.Position;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

	@Position(0)
	private String entity;
	
	@Position(1)
	private String location;
	
}
