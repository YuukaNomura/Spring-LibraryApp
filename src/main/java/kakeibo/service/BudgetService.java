package kakeibo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kakeibo.dao.BudgetDao;
import kakeibo.entity.Budget;
import kakeibo.entity.CalcForm;
import kakeibo.entity.Category;
import kakeibo.entity.Performance;
import kakeibo.entity.ResultForm;

@Service
@Transactional(rollbackFor = Exception.class)
public class BudgetService {

	@Autowired
	private BudgetDao budgetDao;
	
	
	//目標額登録
	public boolean inputBudget(int userID, int[] amounts, String date) {

		boolean result = false;	
		
		date = date + "-01";
		int count = 0;
	
		for(int amount : amounts) {
			count += 1;
			Budget budget = new Budget(userID,count,amount,date);
			result = budgetDao.inputB(budget);		
		}
		return result;
	}
	
	
	
	//目標額検索
	@Transactional(readOnly = true)
	public List<Budget> getBudget(Budget b, int userID) {
		
		b.setUserID(userID);
		String date = b.getDate();
		String date2 = date + "-01";
		b.setDate(date2);
		
		List<Budget> budgets = budgetDao.getB(date2,userID);
		
		return budgets;
	}
	
		
	public CalcForm calc(List<Budget> budgets, List<Performance> performances) {
		
		int budgetIncomesTotalAmount = 0;
		int budgetExpensesTotalAmount = 0;
		int budgetSavings = 0;
		int performanceIncomesTotalAmount = 0;
		int performanceExpensesTotalAmount = 0;
		int performanceSavings = 0; 
		
		for(Budget budget : budgets) {
			if(budget.getCategoryID()<10) {
				budgetExpensesTotalAmount += budget.getAmount();
			} else {
				budgetIncomesTotalAmount += budget.getAmount();
			}
		}
		budgetSavings = budgetIncomesTotalAmount - budgetExpensesTotalAmount;
		
		for(Performance performance : performances) {
			if(performance.getCategoryID()<10) {
				performanceExpensesTotalAmount += performance.getAmount();
			} else {
				performanceIncomesTotalAmount += performance.getAmount();
			}
		}
		performanceSavings = performanceIncomesTotalAmount - performanceExpensesTotalAmount;
		
		CalcForm calcForm = new CalcForm(
				budgetIncomesTotalAmount,
				budgetExpensesTotalAmount,
				budgetSavings,
				performanceIncomesTotalAmount,
				performanceExpensesTotalAmount,
				performanceSavings
				);
		
		return calcForm;
	}
		
	
	public List<ResultForm> x(List<Budget> budgets, List<Performance> performances, List<Category> categoryList) {
		
		int budgetAmount = 0;
		int performanceAmount = 0;
		String categoryName = null;
		List<ResultForm> bfList = new ArrayList<ResultForm>();
		
		for (Category category :categoryList) {
			categoryName = category.getCategoryName();
			performanceAmount = 0;

			for (Budget budget : budgets) {
				if (budget.getCategoryID() == category.getCategoryID()) {
					budgetAmount = budget.getAmount();
				}
			}

			for (Performance performance : performances) {
				if (performance.getCategoryID() == category.getCategoryID()) {
					performanceAmount = performance.getAmount();
				}
			}
			
			ResultForm bf = new ResultForm(
					categoryName,
					performanceAmount,
					budgetAmount
					);
			bfList.add(bf);
		}

		return bfList;
	}
}
