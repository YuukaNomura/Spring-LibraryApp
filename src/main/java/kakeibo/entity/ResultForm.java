package kakeibo.entity;

public class ResultForm {

	private String categoryName;
	private int performanceAmount;
	private int budgetAmount;
	
	
	public ResultForm(String categoryName, int performanceAmount, int budgetAmount) {
		super();
		this.categoryName = categoryName;
		this.performanceAmount = performanceAmount;
		this.budgetAmount = budgetAmount;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getPerformanceAmount() {
		return performanceAmount;
	}


	public void setPerformanceAmount(int performanceAmount) {
		this.performanceAmount = performanceAmount;
	}


	public int getBudgetAmount() {
		return budgetAmount;
	}


	public void setBudgetAmount(int budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	
}
