package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{

	//Bu deðiþkene applicationContex.xml den deðer atayacaðýz.	
	String connectionString;
	
	
	
	public String getConnectionString() {
		return connectionString;
	}



	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Connection string : "+ this.connectionString);
		System.out.println("MsSql'e kaydedildi.");
	}

}
