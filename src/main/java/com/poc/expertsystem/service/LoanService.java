package com.poc.expertsystem.service;

import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;

import com.poc.expertsystem.model.loan.Applicant;
import com.poc.expertsystem.model.loan.LoanResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanService {

	private final KieContainer kieContainer;
	
	public LoanResponse apply(Applicant applicant) {
		//get the stateful session
		var ksession = kieContainer.newKieSession("rulesBasedSession");
		try {
			var result = new LoanResponse();
			ksession.setGlobal("result", result);
			ksession.insert(applicant);
			ksession.fireAllRules();
			return result;
		} finally {
			ksession.dispose();
		}
		
	}
}