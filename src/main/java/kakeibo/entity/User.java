package kakeibo.entity;

public class User {

	 private int userID;
	 private String userPassword;
	 
	 public User() {}
	 
	 public User(int userID, String password) {
		 this.userID = userID;
		 this.userPassword = password;
	 }

	public int getUserID() {
		 return this.userID;
	 }
	 public void setUserID(int userID) {
		 this.userID = userID;
	 }
	 public String getUserPassword() {
		 return this.userPassword;
	 }
	 public void setUserPassword(String password) {
		 this.userPassword = password;
	 }

	
	
}
