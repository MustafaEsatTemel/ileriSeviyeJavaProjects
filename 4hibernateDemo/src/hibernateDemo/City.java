package hibernateDemo;

import javax.persistence.*;

@Entity //Bu city nesnesi bir entitydir, veri taban� nesnesidir.
@Table(name="city")//Bu class hangi tablonun �yesidir ? , city'nin(tablosunun) �yesidir.
public class City {

	//e�er columnlar� vermezsen otomatik de�i�ken isimlerine g�re arama yapmaya �al���r.
	
	@Id//a�a��daki id'in Id oldu�unu belirtiyoruz
	@Column(name="ID")//City tablosunda, s�tunu ID olan alan bu diyoruz.
	private int id;
	
	@Column(name="NAME")//Tabloda s�tunu name olan alan bu diyoruz. Burada CaseSensitive olay� yok. ister b�y�k yaz ister k���k.
	private String Name;//main class'da yapt���m�z sorgular� bu de�i�ken isimlerini kullanarak yap�yoruz.
	
	@Column(name="countryCode")
	private String countryCode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="population")
	private int population;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
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
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
