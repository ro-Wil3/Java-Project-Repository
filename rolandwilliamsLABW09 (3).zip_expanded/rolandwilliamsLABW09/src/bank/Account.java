/*******************************************************************************
* Name: Roland Williams
* Course: (CIS 3970)
* Semester: (Spring 2024)
* Assignment: (Lab 9)
* Date started: (3/9/24)
* Date finished: (3/15/24)
* Description: (Copy Lab W06 and use Inheritance and Polymorphism to clean up and minimize as much code as possible
*******************************************************************************/
package bank;
import java.util.ArrayList;
import java.util.Collections;



//class creates a bank account with essential information
public class Account implements Comparable<Account>, Cloneable{
	private final int accountNum;
	private ArrayList<Integer> Owners;
	private int managerID;
	private double balance;
	private double APY;
	private int primaryID;
	
	public Account(int accountNum, ArrayList<Integer> Owners,int managerID,int primaryID) {
		this.accountNum = accountNum;
		this.Owners = Owners;
		this.setManagerID(managerID);
		this.balance = 0.0;
		this.APY = 0.0;
		this.setPrimaryID(primaryID);
	}	
	public Account(int accountNum,ArrayList<Integer> Owners,int managerID,double balance,int primaryID) {
		this(accountNum, Owners, managerID,primaryID);															//3 Account constructors... all being implemented differently to reduce duplicate code
		this.setBalance(balance);																		//+but still working to effectively be at use
		this.APY = 0.0;
	}
	public Account(int accountNum,ArrayList<Integer> Owners,int managerID,double balance, double APY,int primaryID) {
		this(accountNum, Owners, managerID,balance,primaryID);
		this.setAPY(APY);
	}
	
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setAPY(double APY) {
		this.APY = APY;
	}
	public void setPrimaryID(int primaryID) {
		this.primaryID = primaryID;
	}
	public int getAccountNumber() {
		return accountNum;
	}																		//Mutators for managerID, Balance, and APY
	public ArrayList<Integer> getOwners(){									//Accessors for all class members
		return Owners;
	}
	public int getManagerID() {
		return managerID;
	}
	public double getBalance() {
		return balance;
	}
	public double getAPY() {
		return APY;
	}
	public int getPrimaryID() {
		return primaryID;
	}
	public double addBalance(double amount) {
		return balance+= amount;								
	}
	public boolean addOwner(int ownerID,boolean ownerCheck) {
		if(Owners.contains(ownerID)) {
			return false;					//checking to see if the ID is already in the ArayList and if it is, it returns false
		}
			if(ownerCheck == true) {
				Owners.add(0,ownerID);
		}									//If the primary owner is being added we out it to the first element but if not then it gets added accordingly and returns true
			else {												
				Owners.add(ownerID);
		}
			return true;
	}
									
	public boolean removeOwner(int ownerID) {
		if(Owners.contains(ownerID)) {
			Owners.remove(ownerID);
	}
		else {								//if an ownerID is found in the Owners ArrayList, it is removed from the ArrayList and will return true to end the method
			return false;					//else return false and stops method
	}
		return true;
	}
	public double calcInterest(double APY) {
		double intRate = APY/100/12;				//assumed interest rate was APY/12
		return intRate;									
	}
	@Override
	public String toString() {	
		return String.format("\n%d %d $%,12.2f %5.2f%% (%d) %s",
				accountNum, managerID, balance, APY, primaryID ,Owners);
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof Account)) {
			return false;
		}
		else if(obj == this) {
			return true;
		}
		Account account = (Account) obj;
		if(this.accountNum == account.accountNum) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Account obj) {
	
			if(obj != null) {
				if(this.accountNum == obj.accountNum) {
					return 0;
				}
				else if(this.accountNum > obj.accountNum) {
					return -1;
				}
			}
			return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account clone() throws CloneNotSupportedException {
		Account clone = (Account) super.clone();
		if(Owners != null) {
			clone.Owners = (ArrayList<Integer>) this.Owners.clone();
		}
		return clone;
		}
	public void sort(){
		Collections.sort(Owners);
	}

}

