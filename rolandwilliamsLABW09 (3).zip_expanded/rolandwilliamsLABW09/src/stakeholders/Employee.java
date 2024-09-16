package stakeholders;

// Class created to find commonalities in the associate and manager classes
// and reiterate them while minimizing code in the other classes
public class Employee extends User{
		
	protected String title;
	
	public void setTitle(String title) {
		this.title = title;
	}									//had commonalities of Associate and Manager howerver since it was used in the User class
										//I did a little clean up code
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {							//calling user toString();
		return super.toString() + String.format(" %-25s", title);		
		
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);			//Calling User Equals
		 
		}
	}

