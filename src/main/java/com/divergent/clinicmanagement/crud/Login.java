package com.divergent.clinicmanagement.crud;

/**
 * this class is used for login purpose
 */

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.divergent.clinicmanagement.dao.LoginDao;
import com.divergent.clinicmanagement.dto.LoginDto;

@Component
public class Login {
	private static Logger logger = LoggerFactory.getLogger(Login.class);
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	Login login;
	@Autowired
	Admin admin;
	@Autowired
	Doctor doctor;
	@Autowired
	private Environment env;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	

	Scanner in = new Scanner(System.in);

	/**
	 * this method take input as userName and password from ADMIN and DOCTOR and
	 * login them into corresponding panels
	 */

	public void login() {
		System.setProperty("slf4j.detectLoggerNameMismatch", "true");
		System.out.println("------------------------Login Pannel---------------------------------");
		System.out.println("1. Admin\n2. Doctor\n3. Exit");

		int choice = in.nextInt();
		while (true) {
			switch (choice) {

			case 1:

				login.adminLogin();
				break;

			case 2:
				// System.out.println("Doctor Login Succefully");

				login.doctorLogin();
				break;

			case 3:
				System.exit(0);

			default:
				logger.info("Invalid Input!");
				break;
			}

		}
	}

	private void adminLogin() {
		LoginDto logindto = new LoginDto();
		System.out.println("Enter Username:");
		logindto.setUserName(in.next());

		System.out.println("Enter Password:");
		logindto.setPassword(in.next());

		if (logindto.getUserName().equals("dev") && logindto.getPassword().equals("123")) {

			System.out.println("Login Successfully");

			admin.adminOperations();
		} else {
			// logger.info("Invalid username or passsword\nPlease Enter Valid username and
			// password:");
			logger.info("invalid user");
		}

	}

	private void doctorLogin() {
		LoginDto logindto = new LoginDto();
		System.out.println("Enter Username:");
		logindto.setUserName(in.next());

		System.out.println("Enter Password:");
		logindto.setPassword(in.next());
		
		logindto.setUserName(logindto.getUserName());
		logindto.setPassword(logindto.getPassword());
		loginDao.loginDoctor(logindto);

	}

	public String getPropertyValue() {
		return env.getProperty("props");
	}

}
