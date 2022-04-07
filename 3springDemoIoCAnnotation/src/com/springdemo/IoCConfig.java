package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //Bu bir config dosyas� diye belirtiyoruz.
@ComponentScan("com.springdemo") //belirtti�im paketteki olaylar benden sorulur. Annotation felan varsa �al��s�n hemen.
@PropertySource("classpath:values.properties")//@Value de�erlerinin anas�n� burada belirtiyoruz :D
public class IoCConfig {

	//databasenin �zerine gidip anotasyonla @Component("database") yapmak yerine art�k bu classdan y�netece�iz her�eyi.
	@Bean //buradaki methodun isminin database oldu�undan emin ol ��nk� main'de onu database olarak �a��rd�k.
	public ICustomerDal database() {
		return new MsSqlCustomerDal();
	}
	
	@Bean// ayn� �ekilde service dosyam�z�da bu olarak belirliyoruz.
	public ICustomerService service() {
		return new CustomerManager(database());
	}
	
}
