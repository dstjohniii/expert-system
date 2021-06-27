package com.poc.expertsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.expertsystem.model.Product;
import com.poc.expertsystem.service.JewelleryShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JewelleryShopController {

	private final JewelleryShopService jewelleryShopService;

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);
		jewelleryShopService.getProductDiscount(product);
		return product;
	}
}