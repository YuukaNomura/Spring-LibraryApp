package kakeibo.entity;

public class CalcForm {

	private int budgetIncomesTotalAmount;
	private int budgetExpensesTotalAmount;
	private int budgetSavings;
	private int performanceIncomesTotalAmount;
	private int performanceExpensesTotalAmount;
	private int performanceSavings; 
	
	
	public CalcForm() {}
	
	
	public CalcForm(int budgetIncomesTotalAmount, int budgetExpensesTotalAmount, int budgetSavings,
			int performanceIncomesTotalAmount, int performanceExpensesTotalAmount, int performanceSavings) {
		this.budgetIncomesTotalAmount = budgetIncomesTotalAmount;
	    this.budgetExpensesTotalAmount = budgetExpensesTotalAmount;
	    this.budgetSavings = budgetSavings;
	    this.performanceIncomesTotalAmount = performanceIncomesTotalAmount;
	    this.performanceExpensesTotalAmount = performanceExpensesTotalAmount;
	    this.performanceSavings = performanceSavings;
	}


	public int getBudgetIncomesTotalAmount() {
		return budgetIncomesTotalAmount;
	}


	public void setBudgetIncomesTotalAmount(int budgetIncomesTotalAmount) {
		this.budgetIncomesTotalAmount = budgetIncomesTotalAmount;
	}


	public int getBudgetExpensesTotalAmount() {
		return budgetExpensesTotalAmount;
	}


	public void setBudgetExpensesTotalAmount(int budgetExpensesTotalAmount) {
		this.budgetExpensesTotalAmount = budgetExpensesTotalAmount;
	}


	public int getBudgetSavings() {
		return budgetSavings;
	}


	public void setBudgetSavings(int budgetSavings) {
		this.budgetSavings = budgetSavings;
	}


	public int getPerformanceIncomesTotalAmount() {
		return performanceIncomesTotalAmount;
	}


	public void setPerformanceIncomesTotalAmount(int performanceIncomesTotalAmount) {
		this.performanceIncomesTotalAmount = performanceIncomesTotalAmount;
	}


	public int getPerformanceExpensesTotalAmount() {
		return performanceExpensesTotalAmount;
	}


	public void setPerformanceExpensesTotalAmount(int performanceExpensesTotalAmount) {
		this.performanceExpensesTotalAmount = performanceExpensesTotalAmount;
	}


	public int getPerformanceSavings() {
		return performanceSavings;
	}


	public void setPerformanceSavings(int performanceSavings) {
		this.performanceSavings = performanceSavings;
	}
	
}
