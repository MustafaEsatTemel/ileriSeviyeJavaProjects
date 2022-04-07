package hibernateDemo;

import javax.persistence.*;

@Entity //Bu city nesnesi bir entitydir, veri tabaný nesnesidir.
@Table(name="city")//Bu class hangi tablonun üyesidir ? , city'nin(tablosunun) üyesidir.
public class City {

	//eðer columnlarý vermezsen otomatik deðiþken isimlerine göre arama yapmaya çalýþýr.
	
	@Id//aþaðýdaki id'in Id olduðunu belirtiyoruz
	@Column(name="ID")//City tablosunda, sütunu ID olan alan bu diyoruz.
	private int id;
	
	@Column(name="NAME")//Tabloda sütunu name olan alan bu diyoruz. Burada CaseSensitive olayý yok. ister büyük yaz ister küçük.
	private String Name;//main class'da yaptýðýmýz sorgularý bu deðiþken isimlerini kullanarak yapýyoruz.
	
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
