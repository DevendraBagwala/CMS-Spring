package com.divergent.clinicmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DrugsDto {

	int drugId;
	@NotNull(message = "Name cannot be null")
	@Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
	String drugName;
	String drugWeight;
	@Size(min = 10, max = 250)
	String drugContent;
	String expiryDate;
	String brandName;
	Integer drugMRP;
	
	
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugWeight() {
		return drugWeight;
	}
	public void setDrugWeight(String drugWeight) {
		this.drugWeight = drugWeight;
	}
	public String getDrugContent() {
		return drugContent;
	}
	public void setDrugContent(String drugContent) {
		this.drugContent = drugContent;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getDrugMRP() {
		return drugMRP;
	}
	public void setDrugMRP(Integer drugMRP) {
		this.drugMRP = drugMRP;
	}
	
	
}
