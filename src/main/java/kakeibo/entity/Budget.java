package kakeibo.entity;

public class Budget {
	
	
	private int userID;
	private int categoryID;
	private int amount;
	private String date;
	
	
	public Budget() {}
	
	
	public Budget(int userID, int categoryID, int intAmount, String date) {
		this.userID = userID;
		this.categoryID = categoryID;
		this.amount = intAmount;
		this.date = date;
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
	
	


//	private String date;
//	
//	private int userID;
//	
//	private int amount1;
//	private int amount2;
//	private int amount3;
//	private int amount4;
//	private int amount5;
//	private int amount6;
//	private int amount7;
//	private int amount8;
//	private int amount9;
//	private int amount10;
//	private int amount11;
//	
//	
//	public Budget() {}
//	
//	
//	public Budget(String date, int amount1, int amount2, int amount3, 
//			int amount4, int amount5, int amount6, int amount7, 
//			int amount8, int amount9, int amount10, int amount11) {
//		this.date = date;
//	    this.amount1 = amount1;
//	    this.amount2 = amount2;
//	    this.amount3 = amount3;
//	    this.amount4 = amount4;
//	    this.amount5 = amount5;
//	    this.amount6 = amount6;
//	    this.amount7 = amount7;
//	    this.amount8 = amount8;
//	    this.amount9 = amount9;
//	    this.amount10 = amount10;
//	    this.amount11 = amount11;
//	}
//	
//	
//	public Budget(String date, int userID, int amount1, int amount2, int amount3, 
//			int amount4, int amount5, int amount6, int amount7, 
//			int amount8, int amount9, int amount10, int amount11) {
//		this.date = date;
//		this.userID = userID;
//	    this.amount1 = amount1;
//	    this.amount2 = amount2;
//	    this.amount3 = amount3;
//	    this.amount4 = amount4;
//	    this.amount5 = amount5;
//	    this.amount6 = amount6;
//	    this.amount7 = amount7;
//	    this.amount8 = amount8;
//	    this.amount9 = amount9;
//	    this.amount10 = amount10;
//	    this.amount11 = amount11;
//	}
//	
//	
//	
//	public int getAmount1() {
//		return amount1;
//	}
//	public void setAmount1(int amount1) {
//		this.amount1 = amount1;
//	}
//
//	
//	public int getAmount2() {
//		return amount2;
//	}
//	public void setAmount2(int amount2) {
//		this.amount2 = amount2;
//	}
//
//	
//	public int getAmount3() {
//		return amount3;
//	}
//	public void setAmount3(int amount3) {
//		this.amount3 = amount3;
//	}
//
//	
//	public int getAmount4() {
//		return amount4;
//	}
//	public void setAmount4(int amount4) {
//		this.amount4 = amount4;
//	}
//
//	
//	public int getAmount5() {
//		return amount5;
//	}
//	public void setAmount5(int amount5) {
//		this.amount5 = amount5;
//	}
//
//	
//	public int getAmount6() {
//		return amount6;
//	}
//	public void setAmount6(int amount6) {
//		this.amount6 = amount6;
//	}
//
//	
//	public int getAmount7() {
//		return amount7;
//	}
//	public void setAmount7(int amount7) {
//		this.amount7 = amount7;
//	}
//
//	
//	public int getAmount8() {
//		return amount8;
//	}
//	public void setAmount8(int amount8) {
//		this.amount8 = amount8;
//	}
//
//	
//	public int getAmount9() {
//		return amount9;
//	}
//	public void setAmount9(int amount9) {
//		this.amount9 = amount9;
//	}
//
//	
//	public int getAmount10() {
//		return amount10;
//	}
//	public void setAmount10(int amount10) {
//		this.amount10 = amount10;
//	}
//
//	
//	public int getAmount11() {
//		return amount11;
//	}
//	public void setAmount11(int amount11) {
//		this.amount11 = amount11;
//	}
//
//	
//	public String getDate() {
//		return date;
//	}
//	public void setDate(String date) {
//		this.date = date;
//	}
//	
//	
//	public int getUserID() {
//		return userID;
//	}
//	public void setUserID(int userID) {
//		this.userID = userID;
//	}
	
}
