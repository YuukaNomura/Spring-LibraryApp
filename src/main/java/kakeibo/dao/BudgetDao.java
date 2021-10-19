package kakeibo.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kakeibo.entity.Budget;

@Repository
public class BudgetDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//目標額登録
	public boolean inputB (Budget b) {
		boolean result = false;
		
		//すでに登録されているか確認
		String sql1 = "SELECT * FROM budget WHERE (date = ? AND userid = ?)";
		List<Map<String, Object>> Budgets = jdbcTemplate.queryForList(sql1, Date.valueOf(b.getDate()),b.getUserID());
		
		if(Budgets.size() == 0) {
		
			//DB新規登録処理
			String sql2 = "INSERT INTO budget VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql2,
					b.getUserID(),b.getCategoryID(),b.getAmount(), Date.valueOf(b.getDate()));
		
			result = true;
		
		} else {
			
			//DB更新処理
			String sql2 = "UPDATE budget SET amount = ? WHERE date = ? AND userid = ? AND categoryid = ?";
			jdbcTemplate.update(sql2,
				b.getAmount(), Date.valueOf(b.getDate()), b.getUserID(), b.getCategoryID());
			
			result = true;
		}
		
		return result;
	}
	
	
	
	//目標額検索
	public List<Budget> getB(String date, int userID)  {

		String sql = "SELECT * FROM budget WHERE (date = ? AND userid = ?)";

		List<Map<String, Object>> budgets = jdbcTemplate.queryForList(sql, Date.valueOf(date), userID);
		List<Budget> budgetList = new ArrayList<Budget>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		for(Map<String, Object> eachBudget: budgets) {
			Budget budget = new Budget(
	                    (int) eachBudget.get("userid")
	                    ,(int) eachBudget.get("categoryid")
	                    ,(int) eachBudget.get("amount")
	                    ,sdf.format(eachBudget.get("date"))
			);
			budgetList.add(budget);
		}
		return budgetList;
	}
}
