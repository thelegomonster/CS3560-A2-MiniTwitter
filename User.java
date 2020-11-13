package assignment2;

import java.util.Vector;

public class User implements Int_UserElement {
	private String ID;												//unique ID to identify individual users
	private Vector<String> followers = new Vector<String>(0);		//vector of IDs, lists the user's followers' IDs
	private Vector<String> following = new Vector<String>(0);		//vector of IDs, lists the IDs of the individuals the user is following
	private Vector<String> feed = new Vector<String>(0);			//vector that will hold the Tweets and act as the user's "newsfeed"
	
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
	
	void follow(User followUser) {
		
	}
}
