package stakeholders;

import security.Credential;

// Class is created to find commonalities in the employee and customers class
// and reiterate them to delete the repeated code in those classes and minimize with inheritance
public class User {
	protected Profile profile;
	protected Credential credential;
	
	public Profile getProfile() {
		return profile;			
	}
	public Credential getCredential() {
		return credential;
	}
	@Override
	public String toString() {								
		return String.format("\n%s %s",profile, credential);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof User)) {
			return false;
		}
		else if(obj == this) {							//Description: equals method to compare profile and credentials
			return true;								//Pre-condition: none
		}												//Post-Condition: Used for inheritance purposes but also used to compare an object to of user to another object
		User user = (User) obj;
		if(user.profile.equals((Profile) obj)
				&& user.credential.equals((Credential)obj)) {
			return true;
		}
		return false;
	}
}
