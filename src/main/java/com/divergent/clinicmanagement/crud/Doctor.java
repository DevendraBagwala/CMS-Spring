package com.divergent.clinicmanagement.crud;

/**
 * this class is used for take choice from doctor and perform specific operations
 */

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.dao.DoctorDao;
import com.divergent.clinicmanagement.dto.DoctorDto;

@Component
public class Doctor {
	private static Logger logger = LoggerFactory.getLogger(Doctor.class);
	@Autowired
	DoctorDao ddao;
	/*
	 * @Autowired Doctor doctor;
	 */
	@Autowired
	Login login;

	/*
	 * public Doctor getDoctor() { return doctor; }
	 * 
	 * public void setDoctor(Doctor doctor) { this.doctor = doctor; }
	 */

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public DoctorDao getDdao() {
		return ddao;
	}

	public void setDdao(DoctorDao ddao) {
		this.ddao = ddao;
	}

	Scanner in = new Scanner(System.in);
	ResultSet rs;

	/**
	 * this method take choice from doctor and perform operations like See Patient
	 * List, Add prescription and notes, See appointed Patient and Check Patient
	 * History
	 * 
	 * @param doctorId
	 * @param doctorName
	 */

	public void doctorOperations(int doctorId, String doctorName) {

		logger.info("welcome doctor");
		System.out.println("-----------------------Doctor Pannel-------------------------------------------");
		System.out.println(
				"1. List of Patient\n2. ADD prescription and notes for patient\n3. See Appointed Patient\n4. check Patient history and prescription\n5. Back To Login Pannel");

		int choice = in.nextInt();
		switch (choice) {

		case 1:

			seePatientList(doctorId, doctorName);
			break;

		case 2:

			addPrescription(doctorId, doctorName);
			break;

		case 3:

			seeAppointedPatient(doctorId, doctorName);
			break;

		case 4:

			seePatientHistory(doctorId, doctorName);
			break;

		case 5:

			login.login();

		}
	}

	private void seePatientList(int doctorId, String doctorName) {

		System.out.println("data of patient");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", "Id", "PatientName", "Address", "Disease", "Age",
				"ContactNo");

		List<DoctorDto> seelist = ddao.patientList();
		for (DoctorDto dto : seelist) {
			System.out.printf("%-22d%-22s%-22s%-22s%-22d%-22d\n", dto.getDoctorId(), dto.getPatientName(),
					dto.getAddress(), dto.getDisease(), dto.getAge(), dto.getContactNo());

		}

		doctorOperations(doctorId, doctorName);

	}

	private void addPrescription(int doctorId, String doctorName) {
		DoctorDto dto = new DoctorDto();
		System.out.println("-------Add prescription and note for patient---------");
		System.out.println("Enter  Pateint Name to add prescription and notes");
		dto.setPatientName(in.next());

		System.out.println("Add Prescription");
		dto.setPrescription(in.next());

		System.out.println("Add notes for Patient");
		dto.setNotes(in.next());

		System.out.println("enter date of Prescription:");
		dto.setDate(in.next());

		dto.setDoctorId(dto.getDoctorId());
		dto.setDoctorName(dto.getDoctorName());
		dto.setPrescription(dto.getPrescription());
		dto.setNotes(dto.getNotes());
		dto.setDate(dto.getDate());
		ddao.insertPrescription(dto);

		doctorOperations(doctorId, doctorName);

	}

	private void seeAppointedPatient(int doctorId, String doctorName) {

		System.out.println("");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s\n", "PatientName", "PatientDisease", "DoctorName",
				"DateOfAppointment", "TimeOfAppointment");
		List<DoctorDto> appointlist = ddao.appointList();
		for (DoctorDto dto : appointlist) {
			System.out.printf("%-22s%-22s%-22s%-22s%-22s\n", dto.getPatientName(), dto.getPatientDisease(),
					dto.getDoctorName(), dto.getDateOfAppointment(), dto.getTimeOfAppointment());
		}

		doctorOperations(doctorId, doctorName);

	}

	private void seePatientHistory(int doctorId, String doctorName) {

		System.out.println("---------------------------------History of Patient---------------------------------");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", "Appointed Doctor", "PatientName", "PatientDisease",
				"Prescription", "Notes", "Date");
		List<DoctorDto> histroylist = ddao.patientHistroy();
		for (DoctorDto dto : histroylist) {

			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", doctorName, dto.getPatientName(),
					dto.getPatientDisease(), dto.getPrescription(), dto.getNotes(), dto.getDate());

		}

		doctorOperations(doctorId, doctorName);

	}

}
