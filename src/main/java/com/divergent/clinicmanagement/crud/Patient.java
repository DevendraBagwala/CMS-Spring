package com.divergent.clinicmanagement.crud;
/**
 * this class is used for perform CRUD operations on Patient
 */

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.dao.PatientDao;
import com.divergent.clinicmanagement.dto.PatientDto;
@Component
public class Patient {
	private static Logger logger = LoggerFactory.getLogger(Patient.class);
	@Autowired
	PatientDao pdao;
	/*
	 * @Autowired Patient patient;
	 */
	@Autowired
	Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	/*
	 * public Patient getPatient() { return patient; }
	 * 
	 * 
	 * public void setPatient(Patient patient) { this.patient = patient; }
	 */

	public PatientDao getPdto() {
		return pdao;
	}


	public void setPdto(PatientDao pdto) {
		this.pdao = pdao;
	}


	Scanner in = new Scanner(System.in);

	/**
	 * this method take choice from admin and perform operations like add
	 * patient, delete patient, update patient and see patient list
	 */

	public void patientCRUDOperations() {

		

		System.out.println("1. Add Patient\n2. Update Patient data\n3. See Patient List\n4. Delete Patient\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();

		switch (choice) {

		case 1:
			
			addPatient();
			break;

		case 2:
			
			updatePatient();
			break;

		case 3:

			seePatient();
			break;

		case 4:
			deletePatient();
			break;

		case 5:

			
			admin.adminOperations();
			break;

		default:
			logger.info("Please Enter Valid choice");
			patientCRUDOperations();

		}
	}


	private void addPatient() {
		PatientDto pdto = new PatientDto(); 
		System.out.println("Enter Name:");
		pdto.setPatientName(in.next());

		System.out.println("Enter Address:");
		pdto.setAddress(in.next());

		System.out.println("Enter Disease:");
		pdto.setDisease(in.next());

		System.out.println("Enter Age:");
		pdto.setAge(in.nextInt());

		System.out.println("Enter Contact Number:");
		pdto.setContactNo(in.nextLong());

		if (pdto.getPatientName().equals("") || pdto.getAddress().equals("") || pdto.getDisease().equals("") || pdto.getAge().equals("")
				|| pdto.getContactNo().equals("")) {

			System.out.println("All fields are mandadatary");
		} else {
			
			//PatientDto pdto = new PatientDto();
			pdto.setPatientName(pdto.getPatientName());
			pdto.setId(pdto.getId());
			pdto.setDisease(pdto.getDisease());
			pdto.setAddress(pdto.getAddress());
			pdto.setAge(pdto.getAge());
			pdto.setContactNo(pdto.getContactNo());
			pdao.insert(pdto);
		}

		
		patientCRUDOperations();	
	}

	
    private void updatePatient() {
    	PatientDto pdto = new PatientDto();
		System.out.println("Enter id:");
		pdto.setId(in.nextInt());

		System.out.println("Enter Name:");
		pdto.setPatientName(in.next());

		System.out.println("Enter Address:");
		pdto.setAddress(in.next());

		System.out.println("Enter Disease:");
		pdto.setDisease(in.next());

		System.out.println("Enter Age:");
		pdto.setAge(in.nextInt());

		System.out.println("Enter Contact Number:");
		pdto.setContactNo(in.nextLong());

		
		pdto.setPatientName(pdto.getPatientName());
		pdto.setId(pdto.getId());
		pdto.setDisease(pdto.getDisease());
		pdto.setAddress(pdto.getAddress());
		pdto.setAge(pdto.getAge());
		pdto.setContactNo(pdto.getContactNo());
		pdao.update(pdto);
	
		patientCRUDOperations();
		
	}



	private void seePatient() {
		
		System.out.println("data of patient");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", "Id", "PatientName", "Address", "Disease", "Age",
				"ContactNo");
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("\n");

		List<PatientDto> list = pdao.list();
		for(PatientDto pdto:list) {
		
			
			System.out.printf("%-22d%-22s%-22s%-22s%-22d%-22d\n", pdto.getId(), pdto.getPatientName(), pdto.getAddress(),
					pdto.getDisease(), pdto.getAge(), pdto.getContactNo());
			
		}
		System.out.println("\n");
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		
		patientCRUDOperations();	
	}
	
	
	private void deletePatient() {
		PatientDto pdto = new PatientDto();
		System.out.println("Enter id:");
		pdto.setId(in.nextInt());

		System.out.println("Do you really want to delete patient data \n press Y for yes and N for no:");
		char ch = in.next().charAt(0);
		if (ch == 'Y') {
			
			pdto.setId(pdto.getId());
			pdao.delete(pdto);
		}
		
	
		patientCRUDOperations();

	}

}
