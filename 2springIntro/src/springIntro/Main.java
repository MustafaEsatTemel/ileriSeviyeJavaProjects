package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// Hangi xml ile çalýþacaðýmýzý belirtiyoruz.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	//	CustomerManager cm = new CustomerManager(new MySqlCustomerDal()); bu eski kullaným alttaki örnek IoC ileri seviye kullanýmý.
	
		
		//database nesnesini xml aracýlýðý ile arka planda otomatik ürettik. bean'da belirttiðimiz databaseyi yazýyoruz
		//ardýndan onun genel sýnýfýný (Ana sýnýfýný da), virgülden sonra yazýyoruz. Tüm database türlerini yollayabiliriz yani.
		//Aslýnda aþaðýdaki kod da iyi bir kullaným deðil daha iyilerini ileride göreceksin.
//		CustomerManager cm = new CustomerManager(context.getBean("database",ICustomerDal.class));
//		cm.add();
		
		//Aþaðýdaki örnekte de service id'li bir talebin ICustomerService , yani Ana class türündeki sýnýflarý kabul edeceðini söyledik.
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
		
	}

}
