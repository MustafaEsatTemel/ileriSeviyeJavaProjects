package springIntro;

public class CustomerDal implements ICustomerDal{
	//veri taban� olaylar�.
	
	//Bu de�i�kene applicationContex.xml den de�er atayaca��z.
	String connectionString;
	
	
	
	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}



	@Override
	public void add() {
		System.out.println("Connection string : "+ this.connectionString);
		System.out.println("Oracle veritaban�na kaydedildi.");
		
	}

}
