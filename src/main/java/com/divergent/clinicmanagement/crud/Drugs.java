package com.divergent.clinicmanagement.crud;

/**
 * this class is used for perform CRUD operations on Drugs
 */

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.dao.DrugsDao;
import com.divergent.clinicmanagement.dto.DrugsDto;

@Component
public class Drugs {
	private static Logger logger = LoggerFactory.getLogger(Drugs.class);
	@Autowired
	DrugsDao ddao;
	/*
	 * @Autowired Drugs drugs;
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
	 * public Drugs getDrugs() { return drugs; }
	 * 
	 * public void setDrugs(Drugs drugs) { this.drugs = drugs; }
	 */
	public DrugsDao getDdao() {
		return ddao;
	}

	public void setDdao(DrugsDao ddao) {
		this.ddao = ddao;
	}

	Scanner in = new Scanner(System.in);

	/**
	 * this method take choice from admin and perform operations like add drug,
	 * delete drug, update drug and see drug list
	 */

	public void drugsCRUDOperations() {

		System.out.println("1. Add Drug\n2. Update Drug data\n3. See Drug List\n4. Delete Drug\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
		switch (choice) {

		case 1:

			addDrug();
			break;

		case 2:

			updateDrug();
			break;

		case 3:

			seeDrug();
			break;

		case 4:

			deleteDrug();
			break;

		case 5:

			admin.adminOperations();
			break;

		}

	}

	private void addDrug() {
		DrugsDto ddto = new DrugsDto();
		System.out.println("Enter Drug Name:");
		ddto.setDrugName(in.next());

		System.out.println("Enter Weight of Drug:");
		ddto.setDrugWeight(in.next());

		System.out.println("Enter Drug Content:");
		ddto.setDrugContent(in.next());

		System.out.println("Enter expiry date of drug:");
		ddto.setExpiryDate(in.next());

		System.out.println("Enter Brand Name of Drug:");
		ddto.setBrandName(in.next());

		System.out.println("Enter MRP of drug:");
		ddto.setDrugMRP(in.nextInt());

		if (ddto.getDrugName().equals("") || ddto.getDrugWeight().equals("") || ddto.getDrugContent().equals("")
				|| ddto.getExpiryDate().equals("") || ddto.getBrandName().equals("") || ddto.getDrugMRP().equals("")) {

			logger.info("All fields are mandadatary");

		} else {

			ddto.setDrugId(ddto.getDrugId());
			ddto.setDrugName(ddto.getDrugName());
			ddto.setDrugWeight(ddto.getDrugWeight());
			ddto.setDrugContent(ddto.getDrugContent());
			ddto.setExpiryDate(ddto.getExpiryDate());
			ddto.setBrandName(ddto.getBrandName());
			ddto.setDrugMRP(ddto.getDrugMRP());
			ddao.insert(ddto);

		}

		drugsCRUDOperations();
	}

	private void updateDrug() {
		DrugsDto ddto = new DrugsDto();
		System.out.println("Enter drug id:");
		ddto.setDrugId(in.nextInt());

		System.out.println("Enter Drug Name:");
		ddto.setDrugName(in.next());

		System.out.println("Enter Weight of Drug:");
		ddto.setDrugWeight(in.next());

		System.out.println("Enter Drug Content:");
		ddto.setDrugContent(in.next());

		System.out.println("Enter expiry date of drug:");
		ddto.setExpiryDate(in.next());

		System.out.println("Enter Brand Name of Drug:");
		ddto.setBrandName(in.next());

		System.out.println("Enter MRP of drug:");
		ddto.setDrugMRP(in.nextInt());

		ddto.setDrugId(ddto.getDrugId());
		ddto.setDrugName(ddto.getDrugName());
		ddto.setDrugWeight(ddto.getDrugWeight());
		ddto.setDrugContent(ddto.getDrugContent());
		ddto.setExpiryDate(ddto.getExpiryDate());
		ddto.setBrandName(ddto.getBrandName());
		ddto.setDrugMRP(ddto.getDrugMRP());
		ddao.update(ddto);

		drugsCRUDOperations();

	}

	private void seeDrug() {

		System.out.println("Data of Doctors");
		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", "DrugId", "DrugName", "DrugWeight", "DrugContent",
				"expiryDate", "BrandName", "DrugMRP");

		List<DrugsDto> list = ddao.list();
		for (DrugsDto ddto : list) {
			System.out.printf("%-22d%-22s%-22s%-22s%-22s%-22s%-22d\n", ddto.getDrugId(), ddto.getDrugName(),
					ddto.getDrugWeight(), ddto.getDrugContent(), ddto.getExpiryDate(), ddto.getBrandName(),
					ddto.getDrugMRP());

		}

		drugsCRUDOperations();

	}

	private void deleteDrug() {
		DrugsDto ddto = new DrugsDto();
		System.out.println("Enter drug id:");
		ddto.setDrugId(in.nextInt());

		System.out.println("Do you really want to delete drugs data \n press Y for yes and N for no:");
		char ch = in.next().charAt(0);
		if (ch == 'Y') {

			ddto.setDrugId(ddto.getDrugId());
			ddao.delete(ddto);
		}

		drugsCRUDOperations();

	}

}
