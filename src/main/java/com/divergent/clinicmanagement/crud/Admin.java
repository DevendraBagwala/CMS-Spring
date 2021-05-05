package com.divergent.clinicmanagement.crud;

/**
 * this class is used for take choice from admin for  CRUD operations
 * on patient, doctor ,drugs and lab test
 * and also for book appointment
 */

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Admin {
	private static Logger logger = LoggerFactory.getLogger(Admin.class);
	@Autowired
	Patient patient;
	@Autowired
	DoctorOperate doctorOperate;
	@Autowired
	Drugs drugs;
	@Autowired
	LabTest labTest;
	@Autowired
	MakeAppointment makeappointment;
	@Autowired
	Login login;
	@Autowired
	Admin admin;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DoctorOperate getDoctorOperate() {
		return doctorOperate;
	}

	public void setDoctorOperate(DoctorOperate doctorOperate) {
		this.doctorOperate = doctorOperate;
	}

	public Drugs getDrugs() {
		return drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}

	public LabTest getLabTest() {
		return labTest;
	}

	public void setLabTest(LabTest labTest) {
		this.labTest = labTest;
	}

	public MakeAppointment getMakeappointment() {
		return makeappointment;
	}

	public void setMakeappointment(MakeAppointment makeappointment) {
		this.makeappointment = makeappointment;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * this method take choice from Admin and turn them into specific panel
	 */

	public void adminOperations() {

		Scanner in = new Scanner(System.in);
		System.out.println("------------------------Admin Panel-------------------------");
		System.out.println(
				"1. Patient\n2. Doctor\n3. Drugs\n4. Lab Test\n5. Make appoinment\n6. Go back to Login pannel");
		int choice = in.nextInt();
		while (true) {
			switch (choice) {

			case 1:

				patient.patientCRUDOperations();
				break;

			case 2:
				doctorOperate.doctorCRUDOperations();
				break;

			case 3:

				drugs.drugsCRUDOperations();
				break;

			case 4:

				labTest.labTestCRUDOperations();
				break;

			case 5:
				makeappointment.bookAppointment();
				break;

			case 6:

				login.login();
				break;

			default:
				logger.info("Please Enter Valid choice");

				admin.adminOperations();
				break;

			}
			in.close();
		}
	}

}
