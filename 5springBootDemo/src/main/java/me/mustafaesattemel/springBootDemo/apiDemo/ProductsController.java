package me.mustafaesattemel.springBootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Api'lerde isimlendirme standartımız genelde çoğul olur(ProductsController).
@RestController //RestFulApi olabilmesi için bir anotasyonla belirtiyoruz.
public class ProductsController {
//MVC -> Model - View - Controller : Bizim yaptığımız isteği karşılayan, nasıl yanıtlayacağına karar veren yapı. Mesela
//bir web sayfasında https.....com/products diye biryere gittin, yani controller diye bu bir sayfaya gitmek istiyor diyor,
//ve seni view'e yönlendiriyor. Model ise bizim view'den controllera veyahut controllerden view'e göndereceğimiz data anlamına gelir.
//RestApi'ler %99.9 Json formatında oluyor xml'le de oluyor fakat sektör neredeyse %100 jsonla çalışıyor.
//Json formatı niye var dersen, bu bir standarttır. Bu format aracılığı ile senin uygulaman artık bir mobil uygulamasına
//bir reacte angulara viewe diğer platfromlara data gönderebilir. Yani frontendin herkes olabilir gibi birşey.
	
	
	//GetMapping,Bizim uygulama sunucumuzun ana sayfası, ana istek noktasında  bu ProductsController'in geti çağırılacak demek.
	//Yani biz hiçbirşey yapmasak bile sadece uygulamayı çalıştırsak bunun gelmesini bekleriz.
	@GetMapping("/")
	public String get() {
		return "laptop";
	}
	
	@GetMapping("/products")// localhost:8080/products ekranında Ben product sayfasıyım ulen yazacakmış.
	public String get2() {
		return "Ben product sayfasıyım ulen";
	}
}
