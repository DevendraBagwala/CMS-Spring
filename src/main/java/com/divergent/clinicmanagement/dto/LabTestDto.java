package com.divergent.clinicmanagement.dto;

import javax.validation.constraints.Size;

public class LabTestDto {

	
	int testId;
	@Size(min=10 ,max=50)
	String testName;
	Integer testRate;
	
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Integer getTestRate() {
		return testRate;
	}
	public void setTestRate(Integer testRate) {
		this.testRate = testRate;
	}
	
	
}
