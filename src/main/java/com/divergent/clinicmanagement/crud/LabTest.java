package com.divergent.clinicmanagement.crud;

/**
 * this class is used for perform CRUD operations on Lab Test
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.dao.LabTestDao;
import com.divergent.clinicmanagement.dto.LabTestDto;

@Component
public class LabTest {
	private static Logger logger = LoggerFactory.getLogger(LabTest.class);
	@Autowired
	LabTestDao ldao;
	@Autowired
	Admin admin;
	/*
	 * @Autowired LabTest labTest;
	 */

	/*
	 * public LabTest getLabTest() { return labTest; }
	 * 
	 * public void setLabTest(LabTest labTest) { this.labTest = labTest; }
	 */
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public LabTestDao getLdao() {
		return ldao;
	}

	public void setLdao(LabTestDao ldao) {
		this.ldao = ldao;
	}

	Scanner in = new Scanner(System.in);

	/**
	 * this method take choice from admin and perform operations like add Lab Test,
	 * delete Lab Test, update Lab Test and see Lab Test list
	 */

	public void labTestCRUDOperations() {

		System.out.println("1. Add Test\n2. Update Test data\n3. See Test List\n4. Delete Test Data\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
		switch (choice) {

		case 1:

			addLabTest();
			break;

		case 2:

			updateLabTest();
			break;

		case 3:

			seeLabTest();
			break;

		case 4:

			deleteLabTest();
			break;

		case 5:

			admin.adminOperations();
			break;

		}

	}

	private void addLabTest() {
		LabTestDto ldto = new LabTestDto();
		System.out.println("Enter Test Name:");
		ldto.setTestName(in.next());

		System.out.println("Enter Rate of Test:");
		ldto.setTestRate(in.nextInt());

		if (ldto.getTestName().equals("") || ldto.getTestRate().equals("")) {

			logger.info("All fields are mandadatary");

		} else {

			ldto.setTestId(ldto.getTestId());
			ldto.setTestName(ldto.getTestName());
			ldto.setTestRate(ldto.getTestRate());
			ldao.insert(ldto);
		}

		labTestCRUDOperations();

	}

	private void updateLabTest() {
		LabTestDto ldto = new LabTestDto();
		System.out.println("Enter Test id:");
		ldto.setTestId(in.nextInt());

		System.out.println("Enter Test Name:");
		ldto.setTestName(in.next());

		System.out.println("Enter Rate of Test:");
		ldto.setTestRate(in.nextInt());

		ldto.setTestId(ldto.getTestId());
		ldto.setTestName(ldto.getTestName());
		ldto.setTestRate(ldto.getTestRate());
		ldao.update(ldto);

		labTestCRUDOperations();

	}

	private void seeLabTest() {

		System.out.println("Data of Doctors");
		System.out.printf("%-22s%-22s%-22s\n", "TestId", "TestName", "TestRate");
		List<LabTestDto> list = ldao.labTestlist();
		for (LabTestDto ldto : list) {
			System.out.printf("%-22d%-22s%-22d\n", ldto.getTestId(), ldto.getTestName(), ldto.getTestRate());

		}

		labTestCRUDOperations();

	}

	private void deleteLabTest() {
		LabTestDto ldto = new LabTestDto();
		System.out.println("Enter Test id:");
		ldto.setTestId(in.nextInt());

		System.out.println("Do you really want to delete test data \n press Y for yes and N for no:");
		char ch = in.next().charAt(0);
		if (ch == 'Y') {
			ldto.setTestId(ldto.getTestId());
			ldao.delete(ldto);
		}

		labTestCRUDOperations();

	}

}
