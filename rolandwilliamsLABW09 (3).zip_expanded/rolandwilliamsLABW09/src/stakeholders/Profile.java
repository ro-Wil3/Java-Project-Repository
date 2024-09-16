package stakeholders;

//class is used to create profiles using essential information of the user
public class Profile implements Comparable<Profile>,Cloneable{

	private int ID;
	private String firstname;
	private String lastname;
	private String email;

	public Profile(int ID, String firstname, String lastname, String email) {
		this.setID(ID);
		this.setFirstname(firstname);
		this.setLastname(lastname);							//Profile constructor containing and initializing ID,first name, last name, and email 
		this.setEmail(email);
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getID() {									//accessors and mutators for all class members
		return ID;
	}	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return String.format("\n%7d %-10s %-10s %-23s",
			ID, firstname, lastname, email);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Profile)) {
			return false;
		}	
		else if(obj == this) {
			return true;
		}
		Profile profile = (Profile) obj;
		if(this.ID == profile.ID
				&&this.firstname.equals(profile.firstname)
				&&this.lastname.equals(profile.lastname)
				&&this.email.equals(profile.email)) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Profile obj) {
		if(obj != null) {
			if(this == obj ||this.ID == obj.ID) {
				return 0;
			}
			else if(this.ID > obj.ID) {
				return 1;
			}
			else {
				return -1;
			}
		}
		return -1;
	}
	@Override
	public Profile clone() throws CloneNotSupportedException {
		Profile clone = (Profile) super.clone();
		if(clone != null) {
			clone = new Profile(this.getID(), this.getFirstname(), this.getLastname(), this.getEmail());
		}
		return clone;
	}
}
