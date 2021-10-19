package kakeibo.entity;

public class PerformanceForm {

	private int performanceID;
	private String categoryName;
	private int amount;
	private String date;
	 
	public PerformanceForm() {}
	
	
	public PerformanceForm(int performanceID, String categoryName, int amount, String date) {
		this.performanceID = performanceID;
	    this.categoryName = categoryName;
	    this.amount = amount;
	    this.date = date;
	    }
	
	    
	    public int getPerformanceID() {
	       return this.performanceID;
	    }
	
	    public void setPerformanceID(int performanceID) {
	       this.performanceID = performanceID;
	    }
	
	    public String getCategoryName() {
	       return this.categoryName;
	    }
	
	    public void setCategoryName(String categoryName) {
	       this.categoryName = categoryName;
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
