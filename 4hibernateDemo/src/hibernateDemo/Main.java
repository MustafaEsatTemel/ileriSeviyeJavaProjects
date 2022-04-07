package hibernateDemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {		//configuration dosyam�z� s�yl�yoruz.
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class).buildSessionFactory();
				//�stedi�imiz bir class'� buraya veriyoruz //ard�ndan build ile fabrikay� olu�turduk.
				//(Biz city class'�n� verdik ki city tablosuna ula�al�m)
		
		
			
		//Unit of work ( Database i�lemlerinde Biryerde hata varsa di�er database i�lemini otomatik iptal et gibi bir�ey )
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); //i�lemi ba�lat diyorsun
			
			
			//HQL -> Hibernate Query LAnguage
			
			
			//from City , city class�ndan demek. Gerekli sonu�lar� al ve City t�rl� listeye aktar diyoruz.
			//Mesela a�a��daki �rnekte c.Name kullanm���z. Oradaki Name bizim City class�m�zdaki name de�i�keni.
			//Yani art�k bizim MySQL datalar�n� oradan y�netiyoruz direkt, City class'�ndaki Name de�i�keni,
			//bizim city nameleri tutmakta.
			
			
			//"from City c where c.countryCode='TUR' AND c.district='Ankara'"
			
			//"from City c where c.name LIKE '%kar%'" -> LIKE ile i�inde ge�en anlam� veriyoruz,
			//ilk % ise, �n�nde ne oldu�unun �nemi yok sonras�nda kar olsun
			//son % ise, sonras�nda ne oldu�unun �nemi yok �n�nde kar olsun demek.Yani kar% direkt Kar ile ba�layanlar� getir demek.
			
			//from City c ORDER BY c.Name -> default olarak sonuna ASC(Ascending) gelir. Yani a'dan z'ye. DESC ise tam tersi Z'den a'ya.
			
			//"select c.countryCode from City c GROUP BY c.countryCode" -> City'i country'e g�re grupla demek.
			//select c.countryCode -> Countrycodeleri getir demek.
			//Yani grupluyoruz ya, t�rkiye 70 kere ge�ece�ine 1 kere ge�er.
			//Ama biz �imdi sadece country codeleri getir dedik ya, yani tek bir kolonu �ektik ya oyuzden onu String'e atay�p gezebiliriz.
			//Liste genericini String, for'u da Stringe g�re d�zenleyip gezersin.
			
			
			//City t�r�ndeki bir listemize createquery ile sorgumuzu al�p, getresultlist ile listeye �evirip at�yoruz.
		    //List<City> cities = session.createQuery("select c.countryCode from City c GROUP BY c.Name").getResultList(); 
			//c kullanma sebebimiz k�saltma kullanmak i�in, City yerine c kulland�k yani.
			
			//ard�ndan cities Listemizi foreach ile geziyoruz ve istedi�imiz k�sm� ekrana yazd�rt�yoruz.
	//		for(City cityGezici:cities) {
	//			System.out.println(cityGezici.getCountryCode());
	//		}
			

	/*
			//insert i�lemi
			City city = new City();
			city.setName("Konya 42");	
			city.setCountryCode("TUR");
			city.setDistrict("Ic Anadolu");
			city.setPopulation(100000);
			session.save(city);
			System.out.println("�ehir eklendi");
			
			
			//Update i�lemi - "3024" idli eleman demek
			City cityGuncelle = session.get(City.class, 3024);
			//	System.out.println(cityGuncelle.getName()); City tablosunda de�i�tirece�imiz verinin ismini okuyoruz.
			cityGuncelle.setPopulation(50252);
			session.save(cityGuncelle);

			
			//Delete i�lemi
			City silinecekCity = session.get(City.class, 4000);
			session.delete(silinecekCity);
	*/		
			
			//Mesela a�a��daki �rnekte c.Name yazmam�n sebebi, City class'�nda name olarak belirtti�imiz columnun
			//de�i�ken isminin Name olmas�ndan kaynakl�. E�er de�i�ken ismi k���k name olsayd� k���k name yazacakt�k.
		List<City> denemeEsad = session.createQuery("from City c where c.Name='Konya 42'").getResultList();
		for(City gezici : denemeEsad) {
			System.out.println(gezici.getName());
		}
			
			session.getTransaction().commit(); //ard�ndan i�lemi commitle ger�ekle�tir yani.
		} finally {//hibernate hatalar� otomatik alg�lad��� i�in catch'i yazmad�m.
			factory.close(); //i�lem bittikten sonra fabrikay� kapat da gece h�rs�z girmesin :D
		}
		
	}

}
