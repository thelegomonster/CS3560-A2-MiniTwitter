package assignment2;

import java.util.Vector;

public class User implements Int_UserElement {
	private String ID;												//unique ID to identify individual users
	private Vector<String> followers = new Vector<String>(0);		//vector of IDs, lists the user's followers' IDs
	private Vector<String> following = new Vector<String>(0);		//vector of IDs, lists the IDs of the individuals the user is following
	private Vector<String> feed = new Vector<String>(0);			//vector that will hold the Tweets and act as the user's "newsfeed"
	private long creationTime;										//Time at which User was created
	private long updateTime;										//TIme at which User was last updated
	
	public User() {
		this.creationTime = System.currentTimeMillis();
		this.updateTime = creationTime;
	}
	
	String getID() {
		return this.ID;
	}
	void setID(String newID) {
		this.ID = newID;
	}
	//returns the contents of the User's followers as a String
	String getFollowers() {
		String output = "";
		for(int i = 0; i < followers.size(); i++) {
			output += this.followers.get(i) + " ";
		}
		
		return output;
	}
	
	@Override
	public void accept(Int_Visitor visitor) {
		visitor.visit(this);
	}
	
	void follow(String userID) {
		this.following.add(userID);
	}
	
}
