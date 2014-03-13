/*Bank.java
 * Nickolas Zarzosa
 * ID:5422
 * This class is the core of the program that creates/deletes accounts from the arraylist. 
 * I ran into an error in the declaration of my arraylist for Account and was unable to proceed with debugging my
 * program. 
 * CST 338-SPring 2014
 * 3-09-14
 */
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Bank
{
	private String bank_name;
	private ArrayList<Customer> customers;
	private ArrayList<Account> accounts;//I was unable to fix this error causing my entire code to be unable to run. after
	//searching online for a solution I wasnt able to find one.
	
	private static int Acount=0;
	private static int Ccount=0;
	
	//constructors
	public Bank(String bank_name)
	{
		this.bank_name=bank_name;
		customers = new ArrayList<Customer>();
		accounts = new ArrayList<Account>();
	}
	public Bank()
	{
		this.bank_name="unknown";
		customers = new ArrayList<Customer>();
		accounts = new ArrayList<Account>();
	}
	
	//this method outputs all the accounts and customers from their respective arraylists.
	// Also this mehthod sums up the total balance of the accounts and customers and outputs the value.
	public void bankInfo()
	{
		double sum=0;
		System.out.println("Bank name: "+bank_name);
		System.out.println("number of accounts:"+accounts.size());
		
		for(Account entry: accounts)
		{
			System.out.print("     "+entry.getID()+ " : $");
			System.out.printf("%.2f",entry.getBalance());
			System.out.println();
			sum +=entry.getBalance();
		}
		System.out.println("number of CUstomers: "+customers.size());
		for(Customer entry: customers)
		{
			System.out.println("     "+entry.getname()
					+": "+entry.getSSN());
		}
		System.out.print("total balance: $ ");
		System.out.printf("%.2f",sum);
		System.out.println();
	}
	
	
	//
	public void newAccount(String SSN, int ID, int type, double balance)
	{
		  Account person = new Account();
		  //if(accounts.contains(SSN))
		  //{
		   //System.out.println("Customer creation failed - Duplicated SSN.");
		  //}
		  //else
		  //{
		   //person.setcustomer(name, address, zip_code, SSN);
		   //customers.add(person);
		   //System.out.println("Customer creation - " + name + " is added");
		  //}
		
		  for(Account entry:accounts)
		  {
			  if(SSN.equals(entry.getSSN()))
			  {
				System.out.println("Account creater failed-SSN taken");
				break;
			  }
			  else
			  {
				  Acount++;
				  person.setAccount(SSN, ID, type,balance);
				  accounts.add(person);
				  System.out.println("Account Creation -"+ID+" is added");
				  
			  }
		  }
		
		
	}
	
	//this method creates a new customer in the arraylist.the first method i tried that is commented out
	// was giving me errors that I decided to try another mehthod.
	public void newCustomer(String name,String address, int zip_code, String SSN)
	{
		  Customer person = new Customer();
		  //if(customers.contains(SSN))
		  //{
		   //System.out.println("Customer creation failed - Duplicated SSN.");
		  //}
		  //else
		  //{
		   //person.setcustomer(name, address, zip_code, SSN);
		   //customers.add(person);
		   //System.out.println("Customer creation - " + name + " is added");
		  //}
		  
		  //on the second newcustomer call I am getting an error "arraylist$Itr.checkforComodification(unknown Source)
		  for(Customer entry:customers)
		  {
			  if(SSN.equals(entry.getSSN()))
			  {
				System.out.println("Customer creater failed-SSN taken");
				break;
			  }
			  else
			  {
				  Ccount++;
				  person.setcustomer(name, address, zip_code, SSN);
				  customers.add(person);
				  System.out.println("Customer Creation -"+name+" is added");
				  
			  }
		  }
		  
	}
	
	//this method finds the account with the ID that was passed into the array and outputs the information in the 
	// arraylist at that index.
	public void AccountInfo(int ID)
	{
		ArrayList<Customer> temp=customers;
		for(Account entry:accounts)
		{
			
			if(entry.contains(ID))
			{
				System.out.println("Account info:");
				System.out.println("   number:"+entry.getID());
				System.out.print("     ");
				if(entry.gettype()==1)
				{
					System.out.println("checking");
				}
				else
				{
					System.out.println("savings");
				}
				System.out.println("balance: "+entry.getBalance());
				
				
				//if(entry.getSSN().equals(temp.getSSN()))
				//{
				//	System.out.println("   Customer:"+temp.getname());
				//}
				//used the if to check the SSNs to get the right name
				// matched with ssn number. but wasnt working
				//System.out.println("    Customer:"+entry.get) fix this
			}
			else
			{
				System.out.println("Account("+ID+")"+ "does not exits");
			}
		}
	}
	
	//loops to read in data
	public void readData(String file)
    {
        StringTokenizer inputLine = null ;
        Scanner inputStream = null;
        String delimiter = "," ;
        String line = "" ;
        
        
        try
        {
            inputStream = new Scanner(new FileInputStream(file)) ;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found") ;
            System.exit(0) ;
        }
        int custcount=0;
        custcount = inputStream.nextInt();
        inputStream.nextLine();
        
        for(int i = 0; i<custcount; i++)
        {
            line = inputStream.nextLine() ;
            inputLine = new StringTokenizer(line, delimiter) ;
            
            String name = inputLine.nextToken() ;
            String address = inputLine.nextToken();
            String zip_code = inputLine.nextToken();
            String SSN = inputLine.nextToken();
            
            name = name.substring(1, name.length()-1) ;
            address = address.substring(1, address.length()-1) ;
            int zip = Integer.parseInt(zip_code) ;
            
           
            
            Customer info = new Customer(name, address, zip, SSN) ;
            customers.add(info) ;
        }
        
        Acount = inputStream.nextInt();
        inputStream.nextLine();
        
        for(int i = 0; i<Acount; i++)
        {
            line = inputStream.nextLine() ;
            inputLine = new StringTokenizer(line, delimiter) ;
            
            String ssn = inputLine.nextToken() ;
            String accNum = inputLine.nextToken();
            String accType = inputLine.nextToken();
            String balance = inputLine.nextToken();
            
            
            int pin = Integer.parseInt(accNum) ;
            int type = Integer.parseInt(accType) ;
            double bal = Double.parseDouble(balance) ;
            
            Account stuff = new Account(ssn, pin, type, bal) ;
            accounts.add(stuff) ;
        }
        
        System.out.println("Read Data") ;
    }
	
	
	//this method creates a temporary entry object of customer and is made equal to customers obejct and iterates through the array
	//until it finds the SSN that was passed into this method. once found it will output the information of that element.
	//since the SSN is originally a string it is copied into a temp and converted to integer.
	public void customerInfoWithSSN(int SSN) 
	{
		
		for(Customer entry:customers)
		{
			String temp = entry.getSSN();
			temp.substring(7);
			int check = Integer.parseInt(temp);
			if(check == SSN)//check SSN numbers
			{
				System.out.println("Customer found:");
				System.out.println("name: "+entry.getname());
				System.out.println(entry.getaddress());
				if(entry.gettype()==1)
				{
					System.out.print("   Checking( "+entry.getAccounta().getID()+")");
					System.out.printf("%.2f",entry.getAccounta().getBalance());
					System.out.println();
				}
				else
				{
					System.out.print("   Checking( "+entry.getAccounta().getID()+")");
					System.out.printf("%.2f",entry.getAccounta().getBalance());
					System.out.println();
				}
			}
			
		}
	}
	
	//use the remove functions to remove the element in the arry and move the other objects over to fill the gap
	public void closeAccount(int SSN)
	{
		for(Account entry:accounts)
		{
			
			int check = entry.getSSN();
			if(check == SSN)//check SSN numbers
			{
				Acount--;
				accounts.remove(SSN);
			}
			
		}
	}
	
	//use the remove function to remove the element in the array and move the other objects over to fill the gap
	public void removeCustomer(String SSN)
	{
		for(Customer entry:customers)
		{
			String temp = entry.getSSN();
			temp.substring(7);
			int check = Integer.parseInt(temp);
			if(entry.getSSN().equals(SSN))//check SSN numbers
			{
				Ccount--;
				customers.remove(SSN);
			}
			
		}
	}
	
}
