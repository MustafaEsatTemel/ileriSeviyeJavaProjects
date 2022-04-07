package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// Hangi xml ile �al��aca��m�z� belirtiyoruz.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	//	CustomerManager cm = new CustomerManager(new MySqlCustomerDal()); bu eski kullan�m alttaki �rnek IoC ileri seviye kullan�m�.
	
		
		//database nesnesini xml arac�l��� ile arka planda otomatik �rettik. bean'da belirtti�imiz databaseyi yaz�yoruz
		//ard�ndan onun genel s�n�f�n� (Ana s�n�f�n� da), virg�lden sonra yaz�yoruz. T�m database t�rlerini yollayabiliriz yani.
		//Asl�nda a�a��daki kod da iyi bir kullan�m de�il daha iyilerini ileride g�receksin.
//		CustomerManager cm = new CustomerManager(context.getBean("database",ICustomerDal.class));
//		cm.add();
		
		//A�a��daki �rnekte de service id'li bir talebin ICustomerService , yani Ana class t�r�ndeki s�n�flar� kabul edece�ini s�yledik.
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
		
	}

}
