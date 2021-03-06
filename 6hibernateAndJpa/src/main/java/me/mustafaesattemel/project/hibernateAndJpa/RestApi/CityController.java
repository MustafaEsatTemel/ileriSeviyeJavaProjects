package me.mustafaesattemel.project.hibernateAndJpa.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.mustafaesattemel.project.hibernateAndJpa.Business.ICityService;
import me.mustafaesattemel.project.hibernateAndJpa.Entities.City;

@RestController//Bunun bir rest controller olabilmesi için bu anatasyonla süslememiz gerekir.
@RequestMapping("/api") //localhost:8080(Domainin de gelebilir buraya)/api gibi düşünebilirsin. Kullanıcı bunun api olduğunu anlar yani.
public class CityController {

	private ICityService cityService;

	@Autowired//Otomatik ICityService soyundan kişi bulurumkinii.Buldmm CityManager gel burayaa.
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	//Get işlemi şudur: Ben veri tabanında değişiklik yapmak istemiyorum. Bana data ver.
	@GetMapping("/cities")//localhost:8080/api(Yukarda belirttiğimiz api buraya geliyor yani)/cities .
	public List<City> get(){
		return cityService.getAll();
	}
	
	//@RequestBody : Biz bu parametreyi nereden alacağız ,yapılan isteğin bodysinden alacağız. ?
	
	@PostMapping("/add") //bunları post yaptık çünkü veri tabanında data değiştiriyoruz ekliyoruz siliyoruz güncelliyoruz vb.
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	
	//cities'e bir parametre yollamamız gerekiyor çünkü id'e göre eleman çekeceğiz./{id} ile bu olayı gerçekleştirdik
	//Bir nevi placeholder olarak düşünebilirsin.
	@GetMapping("/cities/{id}") //Yani sen localhost:8080/api/cities/5 yazdığında, id'i 5 olan eleman gelecek.
	public City getById(@PathVariable int id){//Yukarıdaki {id}'i almak için @PathVariable koyduk.
		return cityService.getById(id);
	}
	
	//POSTMAN uygulamasını kullanaraktan apiler ile daha kolay işlem yapabilirsin.
	
}
