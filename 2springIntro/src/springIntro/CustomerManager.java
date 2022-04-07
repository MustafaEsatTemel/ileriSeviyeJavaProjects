package springIntro;

public class CustomerManager implements ICustomerService{
	//iþ kurallarý
	
	
	private ICustomerDal customerDal;
	
	//constructor injection - Dependency injection , Sektörün %99'u constructor injection kullanýr
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
