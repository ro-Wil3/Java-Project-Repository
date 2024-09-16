package stakeholders;

import security.Credential;
//creates Associates using the Profile and Credential classes, uses position name to separate them from customers
public class Associate extends Employee implements Comparable<Associate>, Cloneable{
	
	public Associate(Profile profile, Credential credential,String title) {
		this.profile = profile;
		this.credential = credential;						//Associate constructor with profile, credential. and title class members
		this.setTitle(title);
	}
	
	public Profile getProfile() {							//Mutator for title
		return profile;										//Accessor for all class members						
	}
	public Credential getCredential() {
		return credential;
	}
	@Override
	public String toString() {
		return super.toString();
		
	}	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int compareTo(Associate obj) {
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
	public Associate clone() throws CloneNotSupportedException {
		Associate clone = (Associate) super.clone();
		if(clone != null) {
			clone = new Associate(this.getProfile(), this.getCredential(), this.getTitle());
	}
		return clone;
	}
}
