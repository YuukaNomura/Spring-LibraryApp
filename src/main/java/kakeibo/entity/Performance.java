package kakeibo.entity;

public class Performance {

	
	private int performanceID;
	private int userID;
	private int categoryID;
	private int amount;
	private String date;
	 
	public Performance() {}
	
	    
	    public Performance(int categoryID, int amount, String date) {
	       this.categoryID = categoryID;
	       this.amount = amount;
	       this.date = date;
	    }
	
	    public Performance(int performanceID, int userID, int categoryID, int amount, String date) {
	       this.performanceID = performanceID;
	       this.userID = userID;
	       this.categoryID = categoryID;
	       this.amount = amount;
	       this.date = date;
	    }
	    
	    public Performance(int categoryID, int amount) {
		       this.categoryID = categoryID;
		       this.amount = amount;
		}
	
	    
	    public int getPerformanceID() {
	       return this.performanceID;
	    }
	
	    public void setPerformanceID(int performanceID) {
	       this.performanceID = performanceID;
	    }
	
	    public int getUserID() {
	       return this.userID;
	    }
	
	    public void setUserID(int userID) {
	       this.userID = userID;
	    }
	
	    public int getCategoryID() {
	       return this.categoryID;
	    }
	
	    public void setCategoryID(int categoryID) {
	       this.categoryID = categoryID;
	    }
	
	    public int getAmount() {
	       return this.amount;
	    }
	
	    public void setAmount(int amount) {
	       this.amount = amount;
	    }
	
	    public String getDate() {
	       return this.date;
	    }
	
	    public void setDate(String date) {
	       this.date = date;
	    }
	
}
