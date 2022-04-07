package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //Bu bir config dosyasý diye belirtiyoruz.
@ComponentScan("com.springdemo") //belirttiðim paketteki olaylar benden sorulur. Annotation felan varsa çalýþsýn hemen.
@PropertySource("classpath:values.properties")//@Value deðerlerinin anasýný burada belirtiyoruz :D
public class IoCConfig {

	//databasenin üzerine gidip anotasyonla @Component("database") yapmak yerine artýk bu classdan yöneteceðiz herþeyi.
	@Bean //buradaki methodun isminin database olduðundan emin ol çünkü main'de onu database olarak çaðýrdýk.
	public ICustomerDal database() {
		return new MsSqlCustomerDal();
	}
	
	@Bean// ayný þekilde service dosyamýzýda bu olarak belirliyoruz.
	public ICustomerService service() {
		return new CustomerManager(database());
	}
	
}
