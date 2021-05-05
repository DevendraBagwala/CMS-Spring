package com.divergent.clinicmanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.divergent.clinicmanagement.crud.ClinicManagement;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) {
    	logger.info("Inside the main function");
        System.out.println( "Hello World!" );
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		/*
		 * context.register(JavaConfig.class); context.refresh();
		 */
        logger.debug("ApplicationContext:{}", context);
        ClinicManagement clinicManagement = context.getBean(ClinicManagement.class);
        logger.info(clinicManagement.toString());
        clinicManagement.main();
    }
}
;