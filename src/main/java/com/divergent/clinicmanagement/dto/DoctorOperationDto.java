package com.divergent.clinicmanagement.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DoctorOperationDto {
	
	int doctorId;
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
	String doctorName;
	String email;
	String degree;

	@NotNull
	@Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters.")
	String specialization;
	Integer fee;
	String address;
	@Min(value = 5, message = "Number Should be 10")
    @Max(value = 10, message = "Number Should be 10")
	Long contactNo;
	
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	

}
