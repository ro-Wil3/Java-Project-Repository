package stakeholders;

import security.Credential;
//creates Associates using the Profile and Credential classes, uses position name to 
//separate them from customers and establishes a passcode to separate them from regular associates
public class Manager extends Employee implements Comparable<Manager>, Cloneable{
	
	
	private int passcode;

	public Manager(Profile profile,Credential credential, String title,int passcode) {
		this.profile = profile;
		this.credential = credential;								//Manager constructor with profile, credential, title, and passcode class members
		this.setTitle(title);
		this.setPasscode(passcode);
	}
	public void setPasscode(int passcode) {
		this.passcode = passcode;							//mutators for title and passcode
	}														//Accessors for all class members

	public int getPasscode() {
		return passcode;
	}
	public Profile getProfile() {
		return profile;
	}
	 @Override
	    public String toString() {
	        return super.toString() + String.format("%6d", passcode);
	         //return String.format("\n%s %s %-25s %6d",profile, credential,title,passcode);
	    }
	@Override
	public boolean equals(Object obj) {
		Manager manager = (Manager) obj;
		return super.equals(obj) && this.passcode == manager.passcode;
	}
	@Override 
	public int compareTo(Manager obj) {
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
		return -1;
	}
	@Override
	public Manager clone() throws CloneNotSupportedException {
		Manager clone = (Manager) super.clone();
		if(clone != null) {
			clone = new Manager(this.profile.clone(), this.credential.clone(), this.getTitle(), this.getPasscode());
		}
		return clone;
	}
}
