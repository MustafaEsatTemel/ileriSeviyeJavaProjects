package com.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("database") hem MsSQL'e hemde MySQL'e bunu veremezsin. Main class'� k�zar hangi database ile �al��aca��m diye.
//��nk� mainde  context.getBean("database",ICustomerDal.class); sadece 1 database al�yor.
//@Component("database")Bunu bir sa�a bir sola ta��mak yerine config dosyas�ndan database i�lerini y�netece�iz.
public class MsSqlCustomerDal implements ICustomerDal{

	@Value("${database.connectionString}") //A�a��daki field'a belirtti�im adresteki yaz�y� aktar.
	String connectionString;
	
	
	
	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Connection string : "+ this.connectionString);
		System.out.println("MsSql'e kaydedildi.");
	}

}
