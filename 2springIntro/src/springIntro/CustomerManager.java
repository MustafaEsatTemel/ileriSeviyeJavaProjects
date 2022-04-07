package springIntro;

public class CustomerManager implements ICustomerService{
	//i� kurallar�
	
	
	private ICustomerDal customerDal;
	
	//constructor injection - Dependency injection , Sekt�r�n %99'u constructor injection kullan�r
	/*
	 * public CustomerManager(ICustomerDal customerDal) { this.customerDal =
	 * customerDal; }
	 */
	
	
	//setter injection
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public void add() {
	//	CustomerDal customerDal = new CustomerDal();
		customerDal.add();
	}



}
