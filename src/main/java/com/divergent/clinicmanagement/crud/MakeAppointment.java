package com.divergent.clinicmanagement.crud;
/**
 * this class is used to Book Appointment for Patient
 */

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.divergent.clinicmanagement.dao.MakeAppointmentDao;
import com.divergent.clinicmanagement.dto.MakeAppointmentDto;
@Component
public class MakeAppointment {
	private static Logger logger = LoggerFactory.getLogger(MakeAppointment.class);
	@Autowired
	MakeAppointmentDao mkdao;
	
	@Autowired
	Admin admin;
	

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	

	public MakeAppointmentDao getMkdao() {
		return mkdao;
	}

	public void setMkdao(MakeAppointmentDao mkdao) {
		this.mkdao = mkdao;
	}

	Scanner in = new Scanner(System.in);

	/**
	 * this method take patient name and doctor name from admin and book
	 * appointment for that patient
	 */

	public void bookAppointment() {
		MakeAppointmentDto mkdto = new MakeAppointmentDto();
		System.out.println("Make appointment for Pateint");
		System.out.println("enter Patient Name:");
		mkdto.setPatientName(in.next());

		System.out.println("enter doctor Name");
		mkdto.setDoctorName(in.next());

		System.out.println("Enter Date of appointment");
		mkdto.setDateOfAppointment(in.next());

		System.out.println("Enter Time of appointment");
		mkdto.setTimeOfAppointment(in.next());

		
		mkdto.setPatientName(mkdto.getPatientName());
		mkdto.setDoctorName(mkdto.getDoctorName());
		mkdto.setDateOfAppointment(mkdto.getDateOfAppointment());
		mkdto.setTimeOfAppointment(mkdto.getTimeOfAppointment());
		mkdao.appointment(mkdto);
		
		
		repeateOpearation();

	}

	private void repeateOpearation() {


		System.out.println(
				"\nAre you want to appointment more patient:\nIf yes then press 'Y' or if no then press 'N'\n");
		char ch = in.next().charAt(0);
		if (ch == 'Y') {

			
			bookAppointment();

		} else if (ch == 'N') {

			
			admin.adminOperations();

		} else {

			logger.info("Please Enter Valid choice");
			
			repeateOpearation();

		}

	}

}
