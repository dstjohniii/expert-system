package com.poc.expertsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.expertsystem.model.Product;
import com.poc.expertsystem.service.JewelleryShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JewelleryShopController {

	private final JewelleryShopService jewelleryShopService;

	@GetMapping(value = "/discount", produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		var product = Product.builder()
			.type(type)
			.build();
		jewelleryShopService.getProductDiscount(product);
		return product;
	}
}