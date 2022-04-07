package com.springdemo;

public class CustomerManager implements ICustomerService{
	//iþ kurallarý
	private ICustomerDal customerDal;
	
	//constructor injection

	  public CustomerManager(ICustomerDal customerDal) { 
		  this.customerDal = customerDal; 
		  
	  }
	
	
	


	public void add() {
	//	CustomerDal customerDal = new CustomerDal();
		customerDal.add();
	}



}
