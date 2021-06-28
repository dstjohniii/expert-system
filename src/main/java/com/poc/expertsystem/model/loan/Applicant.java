package com.poc.expertsystem.model.loan;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applicant {
	private String name;
	private BigDecimal annualSalary;
	private int fico;
	private int age;
}
