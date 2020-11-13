package assignment2;

import java.util.Vector;

public class UserGroup implements Int_UserElement{
	private String ID;												//unique ID to identify individual groups
	private Vector<String> followers = new Vector<String>(0);		//vector of IDs to list the members of the group (user and/or user groups)
	
	String getID() {
		return this.ID;
	}
	void setID(String newID) {
		this.ID = newID;
	}
	
	@Override
	public void accept(Int_Visitor visitor) {
		visitor.visit(this);
	}
}
