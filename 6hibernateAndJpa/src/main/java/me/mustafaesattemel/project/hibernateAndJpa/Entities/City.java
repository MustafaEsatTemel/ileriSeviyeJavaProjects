package me.mustafaesattemel.project.hibernateAndJpa.Entities;

import javax.persistence.*;

@Entity//Sen bir veri tabanı nesnesisin.
@Table(name="city")//application.properties'de belirttiğimiz veri tabanının city tablosusun sen diyoruz.
public class City {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //id'nin stratejisini belirliyoruz, yani otomatik artsın diyoruz.
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="countrycode")
	private String countryCode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="population")
	private String population;
	
	public City(int id, String name, String countryCode, String district, String population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	public City() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}
	
	
}