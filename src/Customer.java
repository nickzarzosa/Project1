/*Nickolas Zarzosa
 * Customer.java
 * ID:5422
 * CST 338-SPring 2014
 * 3-09-14
 */
public class Customer
{
	
	private String name;
	private String address;
	private int zip_code;
	private String SSN;
	private Account check;
	
	public Customer()
	{
		this.name="unknown";
		this.address="unknown";
		this.zip_code=00000;
		this.SSN="000-00-0000";
	}
	public Customer(String name,String address,int zip_code,String SSN)
	{
		this.name=name;
		this.address=address;
		this.zip_code=zip_code;
		this.SSN=SSN;
	}
	
	public void setcustomer(String name,String address,int zip_code,String SSN)
	{
		
		this.name=name;
		this.address=address;
		this.zip_code=zip_code;
		this.SSN=SSN;
	}
	
	// get methods
	public String getname()
	{
		return name;
	}
	public String getSSN()
	{
		return SSN;
	}
	
	public String getaddress()
	{
		return address;
	}
	public int getzip()
	{
		return zip_code;
	}
	public Account getAccounta() 
	{
		return null;
	}
	public int gettype() 
	{
		
		return check.gettype();
	}
	
	
	
}
