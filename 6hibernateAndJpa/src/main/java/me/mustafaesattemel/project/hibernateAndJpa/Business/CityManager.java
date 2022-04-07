package me.mustafaesattemel.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.mustafaesattemel.project.hibernateAndJpa.DataAccess.ICityDal;
import me.mustafaesattemel.project.hibernateAndJpa.Entities.City;

@Service //Sen bir iş katmanısın haa.
public class CityManager implements ICityService{

	private ICityDal cityDal;
	
	@Autowired//Gez bakalım paketleri ICityDal'a uygun birşey varsa ver aşağıya. Mantıken uygun olan sadece HibernateCityDal var. Onu verecek
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		
		return this.cityDal.getById(id);
	}

}
