package com.poc.expertsystem.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.poc.expertsystem.model.Location;
import com.poc.expertsystem.model.LocationResults;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

	private final KieContainer kieContainer;
	
	public void getLocation() {
		//get the stateful session
		var ksession = kieContainer.newKieSession("backRulesSession");
		
		//Insert Facts
		var result = new LocationResults();
		ksession.setGlobal("result", result);
		insertFacts(ksession);
		ksession.fireAllRules();
//		ksession.dispose();
		System.out.println(result);
	}
	
	private void insertFacts(KieSession ksession) {
		ksession.insert(Location.builder()
				.entity("Europe")
				.location("World")
				.build());
		
		ksession.insert(Location.builder()
				.entity("France")
				.location("Europe")
				.build());
		
		ksession.insert(Location.builder()
				.entity("Paris")
				.location("France")
				.build());
		
		ksession.insert(Location.builder()
				.entity("Eiffel tower")
				.location("Paris")
				.build());
	}
}