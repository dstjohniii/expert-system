package com.poc.expertsystem.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.poc.expertsystem.model.LocationRequest;
import com.poc.expertsystem.model.LocationResults;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

	private final KieContainer kieContainer;
	
	public LocationResults getLocation(LocationRequest request) {
		//get the stateful session
		var ksession = kieContainer.newKieSession("backRulesSession");
		
		// Insert facts and run rules
		try {
			var result = new LocationResults();
			ksession.setGlobal("result", result);
			insertFacts(request, ksession);
			ksession.fireAllRules();
			return result;
		} finally {
			ksession.dispose();
		}
	}
	
	private void insertFacts(LocationRequest request, KieSession ksession) {
		request.getFacts().forEach(location -> ksession.insert(location));
	}
}