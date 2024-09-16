package bank;

import java.util.ArrayList;
import java.util.Collections;

import stakeholders.Associate;
import stakeholders.Customer;
import stakeholders.Manager;
import stakeholders.Profile;
import stakeholders.User;

// Class is used to grab the user objects which is made of accounts, customer, managers, and associates
// and put them into the right object and output them into the right list of stakeholders
public class Bank {

	private ArrayList<Account> Accounts;
	private ArrayList<Customer> Customers;
	private ArrayList<Manager> Managers;
	private ArrayList<Associate> Associates;
	public int cidGenerator;
	
	public Bank(ArrayList<User> users,ArrayList<Account> account) {
		this.Accounts = new ArrayList<Account>(account);
		this.Customers = new ArrayList<Customer>();
		this.Managers = new ArrayList<Manager>();					//Bank constructor that instantiates the Account, Customer, Manager, and Associate ArrayList
		this.Associates = new ArrayList<Associate>();	
		
		
		for (User user : users) {
	        if (user instanceof Customer) {
	            this.Customers.add((Customer) user);			//Description: Putting each object of user in the right category that it is an instance of
	        } else if (user instanceof Manager) {				//Precondition: None
	            this.Managers.add((Manager) user);				//Post-condition - iterating a loop of user objects and printing them into the right list
	        } else if (user instanceof Associate) {
	            this.Associates.add((Associate) user);
	        }
	}
	}
	@Override
	public String toString() {
		return String.format("%s\n\n%s\n\n%s\n\n%s\n\n", 
				Customers, Managers, Associates, Accounts);
	}

	public void banksort() {
		Collections.sort(Accounts);
		Collections.sort(Customers);
		Collections.sort(Managers);
		Collections.sort(Associates);
	}
	
	public ArrayList<Profile> profilecloning() throws CloneNotSupportedException{
		ArrayList<Profile> Profiles = new ArrayList<>();
		for(int i = 0; i < Customers.size();i++) {
			Profiles.add(Customers.get(i).getProfile().clone());
		}
		for(int i = 0; i < Managers.size();i++) {
			Profiles.add(Managers.get(i).getProfile().clone());
		}
		for(int i = 0; i < Associates.size();i++) {
			Profiles.add(Associates.get(i).getProfile().clone());
		}
		return Profiles;
	}
	}

