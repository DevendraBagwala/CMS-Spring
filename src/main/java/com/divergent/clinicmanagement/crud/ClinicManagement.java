package com.divergent.clinicmanagement.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagement.JavaConfig;
@Component
public class ClinicManagement {
	private static Logger logger = LoggerFactory.getLogger(ClinicManagement.class);
	@Autowired
	Login login;
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public  void main()  {
		
		/*
		 * @SuppressWarnings("resource") AnnotationConfigApplicationContext context =
		 * new AnnotationConfigApplicationContext();
		 * context.getEnvironment().setActiveProfiles("dev");
		 * context.register(JavaConfig.class); context.refresh(); Login login =
		 * context.getBean("login", Login.class);
		 */
    	
    	//logger.info("Properties:{}", login.getPropertyValue());
    	
    	login.login();
		
	}

}
