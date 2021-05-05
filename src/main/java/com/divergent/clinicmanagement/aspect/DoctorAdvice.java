package com.divergent.clinicmanagement.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DoctorAdvice {
	
	private static Logger logger = LoggerFactory.getLogger(DoctorAdvice.class);
	@Before("execution(* com.divergent.clinicmanagement.crud.Doctor.*(..))")
	public void beforeMethod() {
		logger.info("Before Called!!!");
	}
	
	@AfterReturning("execution(* com.divergent.clinicmanagement.crud.Doctor.*(..))")
	public void afterReturning() {
		logger.info("After returning Called!!!");
	}
	
	@AfterThrowing("execution(* com.divergent.clinicmanagement.crud.Doctor.*(..))")
	public void afterThrowing(){
		logger.info("after throwing exception");
	}
	
	@Around("execution(* com.divergent.clinicmanagement.crud.Doctor.*(..))")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable{
		
		String methodName = pjp.getSignature().getName();
		logger.info("Method invoked : " + methodName + "()");
			
		Object retVal = pjp.proceed();
			
		logger.info("After method return value is : " + retVal);
		return methodName;
		
	}


}
