package me.mustafaesattemel.project.hibernateAndJpa.Business;

import java.util.List;

import me.mustafaesattemel.project.hibernateAndJpa.Entities.City;
//Business'e iş kodları yazılır unutma.
public interface ICityService {

	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
	
}
