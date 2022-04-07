package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Main {

	public static void main(String[] args) {
		// A�a��ya �al��aca��m�z config class�n� yazd�k.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IoCConfig.class);

	//	ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
	//	customerDal.add();
		
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
		
	}

}
