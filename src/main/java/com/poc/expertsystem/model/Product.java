package com.poc.expertsystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private String type;
	private int discount;
	
}
