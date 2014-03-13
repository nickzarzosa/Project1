/*Nickolas Zarzosa
 * Account.java
 * CST 338-SPring 2014
 * 3-09-14
 */
public class Account
{
	private String SSN;
	private int ID;
	private int type;
	private double balance;
	
	public Account()
	{
		this.SSN="unknown";
		this.ID=0;
		this.type=0;
		this.balance=0.0;
	}
	public Account(String SSN, int ID,int type,double balance)
	{
		this.SSN=SSN;
		this.ID=ID;
		this.type=type;
		this.balance=balance;
	}
	public void setAccount(String SSN,int ID,int type,double balance)
	{
		this.SSN=SSN;
		this.ID=ID;
		this.type=type;
		this.balance=balance;
	}
	
	
	public int getID()
	{
		return ID;
	}
	public int getSSN()
	{
		String temp = SSN;
		temp.substring(7);
		int check = Integer.parseInt(temp);
		return check;
	}
	public double getBalance()
	{
		return balance;
	}
	public int gettype()
	{
		return type;
	}
	public boolean contains(int ID) 
	{
		if(this.ID==ID)
		{
			return true;
		}
		return false;
	}
}
