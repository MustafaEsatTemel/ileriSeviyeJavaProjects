package hibernateDemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {		//configuration dosyamýzý söylüyoruz.
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class).buildSessionFactory();
				//Ýstediðimiz bir class'ý buraya veriyoruz //ardýndan build ile fabrikayý oluþturduk.
				//(Biz city class'ýný verdik ki city tablosuna ulaþalým)
		
		
			
		//Unit of work ( Database iþlemlerinde Biryerde hata varsa diðer database iþlemini otomatik iptal et gibi birþey )
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction(); //iþlemi baþlat diyorsun
			
			
			//HQL -> Hibernate Query LAnguage
			
			
			//from City , city classýndan demek. Gerekli sonuçlarý al ve City türlü listeye aktar diyoruz.
			//Mesela aþaðýdaki örnekte c.Name kullanmýþýz. Oradaki Name bizim City classýmýzdaki name deðiþkeni.
			//Yani artýk bizim MySQL datalarýný oradan yönetiyoruz direkt, City class'ýndaki Name deðiþkeni,
			//bizim city nameleri tutmakta.
			
			
			//"from City c where c.countryCode='TUR' AND c.district='Ankara'"
			
			//"from City c where c.name LIKE '%kar%'" -> LIKE ile içinde geçen anlamý veriyoruz,
			//ilk % ise, önünde ne olduðunun önemi yok sonrasýnda kar olsun
			//son % ise, sonrasýnda ne olduðunun önemi yok önünde kar olsun demek.Yani kar% direkt Kar ile baþlayanlarý getir demek.
			
			//from City c ORDER BY c.Name -> default olarak sonuna ASC(Ascending) gelir. Yani a'dan z'ye. DESC ise tam tersi Z'den a'ya.
			
			//"select c.countryCode from City c GROUP BY c.countryCode" -> City'i country'e göre grupla demek.
			//select c.countryCode -> Countrycodeleri getir demek.
			//Yani grupluyoruz ya, türkiye 70 kere geçeceðine 1 kere geçer.
			//Ama biz þimdi sadece country codeleri getir dedik ya, yani tek bir kolonu çektik ya oyuzden onu String'e atayýp gezebiliriz.
			//Liste genericini String, for'u da Stringe göre düzenleyip gezersin.
			
			
			//City türündeki bir listemize createquery ile sorgumuzu alýp, getresultlist ile listeye çevirip atýyoruz.
		    //List<City> cities = session.createQuery("select c.countryCode from City c GROUP BY c.Name").getResultList(); 
			//c kullanma sebebimiz kýsaltma kullanmak için, City yerine c kullandýk yani.
			
			//ardýndan cities Listemizi foreach ile geziyoruz ve istediðimiz kýsmý ekrana yazdýrtýyoruz.
	//		for(City cityGezici:cities) {
	//			System.out.println(cityGezici.getCountryCode());
	//		}
			

	/*
			//insert iþlemi
			City city = new City();
			city.setName("Konya 42");	
			city.setCountryCode("TUR");
			city.setDistrict("Ic Anadolu");
			city.setPopulation(100000);
			session.save(city);
			System.out.println("Þehir eklendi");
			
			
			//Update iþlemi - "3024" idli eleman demek
			City cityGuncelle = session.get(City.class, 3024);
			//	System.out.println(cityGuncelle.getName()); City tablosunda deðiþtireceðimiz verinin ismini okuyoruz.
			cityGuncelle.setPopulation(50252);
			session.save(cityGuncelle);

			
			//Delete iþlemi
			City silinecekCity = session.get(City.class, 4000);
			session.delete(silinecekCity);
	*/		
			
			//Mesela aþaðýdaki örnekte c.Name yazmamýn sebebi, City class'ýnda name olarak belirttiðimiz columnun
			//deðiþken isminin Name olmasýndan kaynaklý. Eðer deðiþken ismi küçük name olsaydý küçük name yazacaktýk.
		List<City> denemeEsad = session.createQuery("from City c where c.Name='Konya 42'").getResultList();
		for(City gezici : denemeEsad) {
			System.out.println(gezici.getName());
		}
			
			session.getTransaction().commit(); //ardýndan iþlemi commitle gerçekleþtir yani.
		} finally {//hibernate hatalarý otomatik algýladýðý için catch'i yazmadým.
			factory.close(); //iþlem bittikten sonra fabrikayý kapat da gece hýrsýz girmesin :D
		}
		
	}

}
