package driver;


import bank.Account;
import bank.Bank;
import security.Credential;
import stakeholders.Associate;
import stakeholders.Customer;
import stakeholders.Manager;
import stakeholders.Profile;
import stakeholders.User;

import java.io.*;
import java.util.ArrayList;
// class is created to move load methods from the Bank class and make static for easier
// access to the main method
public class Driver{
	 
	public static int loadCustomers(String fileName, int credentialID,ArrayList<User> user)throws IOException{		 
		File file = new File(fileName);
		FileInputStream fistream = new FileInputStream(file);
		DataInputStream distream = new DataInputStream(fistream);			
		while(distream.available()!= 0) {		
			int ID = distream.readInt();
			String firstName = distream.readUTF();
			String lastName = distream.readUTF();					
			String email = distream.readUTF();							
			String username = distream.readUTF();
			String password = distream.readUTF();
			short pin = distream.readShort();
		
			Profile profile = new Profile(ID,firstName,lastName,email);
			Credential credential = new Credential(credentialID++,username,password,pin);
			Customer customer = new Customer(profile,credential);
			user.add(customer);
			
		}
		distream.close();				
		return credentialID;
	
	}
	public static int loadManagers(String fileName, int credentialID,ArrayList<User> user) throws IOException{
		File file = new File(fileName);
		FileInputStream fistream = new FileInputStream(file);
		DataInputStream distream = new DataInputStream(fistream);
		while(distream.available()!= 0) {		
			int ID = distream.readInt();
			String firstName = distream.readUTF();
			String lastName = distream.readUTF();
			String email = distream.readUTF();								
			String username = distream.readUTF();							
			String password = distream.readUTF();
			short pin = distream.readShort();
			int passcode = distream.readInt();
			String title = distream.readUTF();
			
			Profile profile = new Profile(ID,firstName,lastName,email);
			Credential credential = new Credential(credentialID++,username,password,pin);
			Manager manager = new Manager(profile,credential,title,passcode);
			user.add(manager);
			
	}
		
		distream.close();
		return credentialID;
	
}
	public static int loadAssociates(String fileName, int credentialID,ArrayList<User> user) throws IOException{
		File file = new File(fileName);
		FileInputStream fistream = new FileInputStream(file);
		DataInputStream distream = new DataInputStream(fistream);
		while(distream.available()!= 0) {		
			int ID = distream.readInt();
			String firstName = distream.readUTF();
			String lastName = distream.readUTF();											//similiar to the methods above
			String email = distream.readUTF();
			String username = distream.readUTF();
			String password = distream.readUTF();
			short pin = distream.readShort();
			String title = distream.readUTF();
			
			Profile profile = new Profile(ID,firstName,lastName,email);
			Credential credential = new Credential(credentialID++,username,password,pin);
			Associate associate = new Associate(profile,credential,title);
			user.add(associate);
			
	}
		distream.close();
		return credentialID;
	
}
	public static ArrayList<Account> loadAccounts(String fileName, ArrayList<Account>Account)throws IOException{
		File file = new File(fileName);
		FileInputStream fistream = new FileInputStream(file);
		DataInputStream distream = new DataInputStream(fistream);
	
		while(distream.available()!= 0) {	
			int accountNum = distream.readInt();
			int managerID = distream.readInt();
			double balance = distream.readDouble();
			double APY = distream.readDouble();
			int numOwners = distream.readInt();
			ArrayList<Integer> Owners = new ArrayList<>();						//similar to methods above, except I created a loop given the amount of owners and displayed 
	
			int primaryID = distream.readInt(); 
            	Owners.add(0,primaryID);

            	for (int i = 1; i < numOwners; i++) {
            		Owners.add(distream.readInt());
            	}
            	Account account = new Account(accountNum,Owners,managerID,balance,APY,primaryID);
            	Account.add(account);
            	account.sort();
	
		}
		distream.close();
		return Account;
	}
	
	

	public static void main(String[] args) throws IOException, CloneNotSupportedException {	
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Account> accounts = new ArrayList<>();
		int credentialID = 1000000;
		
		credentialID = loadCustomers(args[0], credentialID, users);
		credentialID = loadManagers(args[1], credentialID, users);
		credentialID = loadAssociates(args[2], credentialID, users);
		loadAccounts(args[3], accounts);
		
		
		Bank CISbank = new Bank(users, accounts);

		CISbank.banksort();
		ArrayList<Profile> profiles = CISbank.profilecloning();
		
		profiles.sort(null);
		System.out.println(profiles);
		System.out.println();
		System.out.println(CISbank);
		
	}



}
