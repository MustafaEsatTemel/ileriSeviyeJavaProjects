package me.mustafaesattemel.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.mustafaesattemel.project.hibernateAndJpa.Entities.City;

//JPA ilk başta ORM gibi ortaya çıkmışken daha sonra javada standart haline geliyor.
//Yani hibernate'de Spring'de bu JPA'yı implemente ediyor. Hani biz eski projelerimizde SessionFactory felan oluşturmuştuk
//ya, onlar burada jpa aracılığı ile otomatik oluşacak yani.

@Repository//Hani hibernateyi arayan bir autowired vardı ya, o arayan arkadaş çok yorulmasın diye kendimizi belirttik.
public class HibernateCityDal implements ICityDal{
	
	//SessionFactory'i buradan yöneteceğiz gibi düşünebilirsin.
	private EntityManager entityManager;	
	
	
	//Bizim için otomatik hibernate enjeksiyonu yapacak. Paketlere bakacak mesela bu çocuk hangi yazılımı kullanmış diye
	//hibernateyi görünce tamamdır ben hibernate enjeksiyonu yapayım diyecek.
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional//AOP - Aspect Oriented Programming. Kısaca senin kodun build olduğunda, Session açma ve kapama kodlarını otomatik koyuyor.
	public List<City> getAll() {
		Session session =entityManager.unwrap(Session.class);//Jpa bizim için hibernate ile ilgili olan tüm enjeksiyonları gerçekleştiriyor.
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class); //bunun mantığını anlamaya çalış.
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);//tek bunu yaptığımızda veri tabanından silmedi, üstteki cityToDeleteyi de yazdık
		
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class); 
		
		City city = session.get(City.class, id); //City classımızı map etsin, ve ordaki id'e göre işlem yapsın diyoruz.
		
		return city;
	}

}
