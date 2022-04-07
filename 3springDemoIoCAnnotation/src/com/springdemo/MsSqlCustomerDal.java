package com.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("database") hem MsSQL'e hemde MySQL'e bunu veremezsin. Main class'ý kýzar hangi database ile çalýþacaðým diye.
//çünkü mainde  context.getBean("database",ICustomerDal.class); sadece 1 database alýyor.
//@Component("database")Bunu bir saða bir sola taþýmak yerine config dosyasýndan database iþlerini yöneteceðiz.
public class MsSqlCustomerDal implements ICustomerDal{

	@Value("${database.connectionString}") //Aþaðýdaki field'a belirttiðim adresteki yazýyý aktar.
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
