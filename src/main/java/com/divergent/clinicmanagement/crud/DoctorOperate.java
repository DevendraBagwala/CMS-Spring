package com.divergent.clinicmanagement.crud;
import java.util.List;

/**
 * this class is used for perform CRUD operations on Doctor
 */

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.dao.DoctorOperationDao;
import com.divergent.clinicmanagement.dto.DoctorOperationDto;
@Component
public class DoctorOperate {
	private static Logger logger = LoggerFactory.getLogger(DoctorOperate.class);
	
	@Autowired
	DoctorOperationDao dodao;
	/*
	 * @Autowired DoctorOperate doctorOperate;
	 */
	@Autowired
	Admin admin;
	
	/*
	 * public DoctorOperate getDoctorOperate() { return doctorOperate; }
	 * 
	 * public void setDoctorOperate(DoctorOperate doctorOperate) {
	 * this.doctorOperate = doctorOperate; }
	 */
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public DoctorOperationDao getDodao() {
		return dodao;
	}

	public void setDodao(DoctorOperationDao dodao) {
		this.dodao = dodao;
	}

	Scanner in = new Scanner(System.in);

	/**
	 * this method take choice from admin and perform operations like add
	 * doctor, delete doctor, update doctor and see doctor list
	 */

	public void doctorCRUDOperations() {

		
		System.out.println("1. Add Doctor\n2. Update Doctor data\n3. See Doctor List\n4. Delete Doctor\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
		switch (choice) {

		case 1:

			addDoctor();
			break;

		case 2:

			updateDoctor();
			break;

		case 3:

			seeDoctor();
			break;

		case 4:

			deleteDoctor();
			break;

		case 5:
			
			admin.adminOperations();
			break;
		}
	}

	private void addDoctor() {
		DoctorOperationDto dodto = new DoctorOperationDto();
		System.out.println("Enter Doctor Name:");
		dodto.setDoctorName(in.next());

		System.out.println("Enter Email Id:");
		dodto.setEmail(in.next());

		System.out.println("Enter Degree Name:");
		dodto.setDegree(in.next());

		System.out.println("Enter Specialization of docctor:");
		dodto.setSpecialization(in.next());

		System.out.println("Enter fees of docctor:");
		dodto.setFee(in.nextInt());

		System.out.println("Enter address of docctor:");
		dodto.setAddress(in.next());

		System.out.println("Enter Contact Number:");
		dodto.setContactNo(in.nextLong());

		if (dodto.getDoctorName().equals("") || dodto.getEmail().equals("") || dodto.getDegree().equals("")
				|| dodto.getSpecialization().equals("") || dodto.getFee().equals("") || dodto.getAddress().equals("")
				|| dodto.getContactNo().equals("")) {

			logger.info("All fields are mandadatary");

		} else {

			
			dodto.setDoctorId(dodto.getDoctorId());
			dodto.setDoctorName(dodto.getDoctorName());
			dodto.setEmail(dodto.getEmail());
			dodto.setSpecialization(dodto.getSpecialization());
			dodto.setDegree(dodto.getDegree());
			dodto.setFee(dodto.getFee());
			dodto.setAddress(dodto.getAddress());
			dodto.setContactNo(dodto.getContactNo());
			dodao.insert(dodto);

		}

		
		doctorCRUDOperations();
	}

	private void updateDoctor() {
		DoctorOperationDto dodto = new DoctorOperationDto();
		System.out.println("Enter id:");
		dodto.setDoctorId(in.nextInt());

		System.out.println("Enter Doctor Name:");
		dodto.setDoctorName(in.next());

		System.out.println("Enter Email Id:");
		dodto.setEmail(in.next());

		System.out.println("Enter Degree Name:");
		dodto.setDegree(in.next());

		System.out.println("Enter Specialization of docctor:");
		dodto.setSpecialization(in.next());

		System.out.println("Enter fees of docctor:");
		dodto.setFee(in.nextInt());

		System.out.println("Enter address of docctor:");
		dodto.setAddress(in.next());

		System.out.println("Enter Contact Number:");
		dodto.setContactNo(in.nextLong());

		
		dodto.setDoctorName(dodto.getDoctorName());
		dodto.setDoctorId(dodto.getDoctorId());
		dodto.setSpecialization(dodto.getSpecialization());
		dodto.setDegree(dodto.getDegree());
		dodto.setEmail(dodto.getEmail());
		dodto.setFee(dodto.getFee());
		dodto.setAddress(dodto.getAddress());
		dodto.setContactNo(dodto.getContactNo());
		dodao.update(dodto);

	   doctorCRUDOperations();
	}

	private void seeDoctor() {

		System.out.println("Data of Doctors");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", "DoctorId", "DoctorName", "email", "Degree",
				"specialization", "Fee", "Address", "ContactNo");

		List<DoctorOperationDto> list = dodao.list();
		for(DoctorOperationDto dodto:list) {

				System.out.printf("%-22d%-22s%-22s%-22s%-22s%-22d%-22s%-22d\n", dodto.getDoctorId(), dodto.getDoctorName(), dodto.getEmail(), dodto.getDegree(),
						dodto.getSpecialization(), dodto.getFee(), dodto.getAddress(), dodto.getContactNo());

			}
		
		doctorCRUDOperations();

	}

	private void deleteDoctor() {
		DoctorOperationDto dodto = new DoctorOperationDto();
		System.out.println("Enter id:");
		dodto.setDoctorId(in.nextInt());

		System.out.println("Do you really want to delete doctor data \n press Y for yes and N for no:");
		char ch = in.next().charAt(0);
		if (ch == 'Y') {

			dodto.setDoctorId(dodto.getDoctorId());
			dodao.delete(dodto);
		}

		
		doctorCRUDOperations();

	}

}
