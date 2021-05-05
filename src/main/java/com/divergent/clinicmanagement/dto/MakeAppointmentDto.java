package com.divergent.clinicmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MakeAppointmentDto {
	@NotNull(message = "Name cannot be null")
	@Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
	private String patientName;
	@NotNull(message = "Name cannot be null")
	@Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
	private String doctorName;
	private String disease;
	private String specialization;
	private int doctorFee;
	private String dateOfAppointment;
	private String timeOfAppointment;
	
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(int doctorFee) {
		this.doctorFee = doctorFee;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getTimeOfAppointment() {
		return timeOfAppointment;
	}
	public void setTimeOfAppointment(String timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}
	

	
}
