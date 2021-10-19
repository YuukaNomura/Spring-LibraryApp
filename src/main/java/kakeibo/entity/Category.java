package kakeibo.entity;

public class Category {

	 private int categoryID;
	 private String categoryName;
	 private int bop;
	     
	 public Category() {}
	 
	 public Category(int categoryID, String categoryName, int bop) {
	    this.categoryID = categoryID;
	    this.categoryName = categoryName;
	    this.bop = bop;
	 }
	 


		public int getCategoryID() {
	        return this.categoryID;
	     }
	 
	     public void setCategoryID(int categoryID) {
	        this.categoryID = categoryID;
	     }
	  
	     public String getCategoryName() {
	       return this.categoryName;
	     }
	  
	     public void setCategoryName(String categoryName) {
	        this.categoryName = categoryName;
	     }
	  
	     public int getBOP() {
	        return this.bop;
	     }
	 
	     public void setBOP(int bop) {
	        this.bop = bop;
	     }
	
}
