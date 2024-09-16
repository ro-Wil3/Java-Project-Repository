package security;

//class implements the user's secure information into the neccessary classes of what type of person they are as a stakeholder 
public class Credential implements Cloneable{
	
	private int CID;
	private String username;
	private String password;
	private int pin;
	
	public Credential(int CID, String username,String password,int pin){
		this.CID = CID;
		this.setUsername(username);
		this.setPassword(password);									//Credential constructor with credentialID, username, password, and pin
		this.setPin(pin);
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPin(int pin) {								//Mutators for username, password, and pin
		this.pin = pin;											//Accessors for all class members
	}
	public int getCID() {
		return CID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getPin() {
		return pin;
	}
	@Override
	public String toString() {
		return String.format("%7d %-20s %-16s %4d", 
				CID, username, password, pin);
	} 
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Credential)) {
			return false;
	}
		else if(obj == this) {
			return true;
	}
		Credential credential = (Credential) obj;
		if(this.CID == credential.CID 
				&&this.username.equals(credential.username)
				&&this.password.equals(credential.password)
				&&this.pin == credential.pin) {
			return true;
	}
		return false;
	}
	@Override
	public Credential clone() throws CloneNotSupportedException {
		Credential clone = (Credential) super.clone();
		if(clone != null) {
			clone = new Credential(this.getCID(), this.getUsername(), this.getPassword(), this.getPin());
	}
		return clone;
	}
}
