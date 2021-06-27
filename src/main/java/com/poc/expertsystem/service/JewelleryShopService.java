package com.poc.expertsystem.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.poc.expertsystem.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JewelleryShopService {

	private final KieContainer kieContainer;
	
	public Product getProductDiscount(Product product) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
}