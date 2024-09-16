package stakeholders;

import security.Credential;
//creates Customers using the Profile and Credential classes
public class Customer extends User implements Comparable<Customer> ,Cloneable{
	
	public Customer(Profile profile, Credential credential) {
		this.profile = profile;
		this.credential = credential;					//Constructor with parameters profile and credentials
	}												
	public Profile getProfile() {
		return profile;
	}											//Accessors for all class members and no mutators
	public Credential getCredential() {
		return credential;
	}
	@Override
	public String toString() { 
		return super.toString();
		//return String.format("\n%s %s", profile, credential);
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
		}
	
	@Override
	public int compareTo(Customer obj) {
		if(obj != null) {
			if(obj != null) {
				String thisLastname = this.profile.getLastname();
				String objLastname = obj.profile.getLastname();
				if(this == obj || thisLastname.equals(objLastname)) {
					return 0;
		}
				else if(thisLastname.compareTo(objLastname) > 0) {
					return 1;
		}
				else {
					return -1;
	}
	}
	}
		return -1;
}
	@Override
	public Customer clone() throws CloneNotSupportedException {
		Customer clone = (Customer) super.clone();
		if(clone != null) {
			clone = new Customer(this.getProfile(), this.getCredential());
		}
		return clone;
	}
}
