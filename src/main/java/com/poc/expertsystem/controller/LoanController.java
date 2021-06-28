package com.poc.expertsystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.expertsystem.model.loan.Applicant;
import com.poc.expertsystem.model.loan.LoanResponse;
import com.poc.expertsystem.service.LoanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoanController {

	private final LoanService loanService;
	
	@PostMapping(value = "/loan", produces = "application/json")
	public LoanResponse loan(@RequestBody Applicant request) {
		return loanService.apply(request);
	}
}