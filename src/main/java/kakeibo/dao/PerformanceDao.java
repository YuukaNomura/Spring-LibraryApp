package kakeibo.dao;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kakeibo.entity.Performance;

@Repository
public class PerformanceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//登録処理
	public boolean inputP(Performance p)  {
		//ID自動採番処理
		String sql1 = "SELECT MAX(performanceid) FROM performance";
		Map<String, Object> performance = jdbcTemplate.queryForMap(sql1);

		int performanceId = (int) performance.get("max");
		p.setPerformanceID(++performanceId);

		//DB新規登録処理
		boolean result = false;
		String sql2 = "INSERT INTO performance VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql2,
			p.getPerformanceID(),p.getUserID(),p.getCategoryID(),p.getAmount(), Date.valueOf(p.getDate()));
		result = true;
	    return result;
		}
		
		
		
	//検索処理（日付）
	public List<Performance> getPByDate(int userID, String date)  {

		String sql = "SELECT * FROM performance WHERE (userid = ? AND date = ?) ";

		List<Map<String, Object>> performances = jdbcTemplate.queryForList(sql, userID,Date.valueOf(date));
		List<Performance> performanceList = new ArrayList<Performance>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		for(Map<String, Object> eachPerformance: performances) {
			Performance performance = new Performance(
	                    (int) eachPerformance.get("performanceid")
	                    ,(int) eachPerformance.get("userid")
	                    ,(int) eachPerformance.get("categoryid")
	                    ,(int) eachPerformance.get("amount")
	                    ,sdf.format(eachPerformance.get("date"))
			);
			performanceList.add(performance);
		}
	        return performanceList;
	}
	
	
	
	//検索処理2（日付）
	public ArrayList<Performance> getPGroupByCategory(int userID, String date)  {

		String sql = "SELECT categoryid, SUM(amount) as sum FROM performance  "
				+ "WHERE date BETWEEN ? AND ? AND userid = ? GROUP BY categoryid ";
		
		char month1 = date.charAt(5);
		char month2 = date.charAt(6);
		
		String date2 = null;
		if (month1 == '0' && month2 == '2') {
			date2 = date + "-28";
		} else if ((month1 == '0' && month2 == '4') || (month1 == '0' && month2 == '6') || (month1 == '0' && month2 == '9') || (month1 == '1' && month2 == '1')) {
			date2 = date + "-30";
		} else {
			date2 = date + "-31";
		}
		date += "-01";

		List<Map<String, Object>> performances = jdbcTemplate.queryForList(sql, Date.valueOf(date), Date.valueOf(date2), userID);
		ArrayList<Performance> performanceList = new ArrayList<Performance>();

		for(Map<String, Object> eachPerformance: performances) {
			Performance performance = new Performance(
	                    (int) eachPerformance.get("categoryid")
	                    ,Math.toIntExact((long) eachPerformance.get("sum"))
			);
			performanceList.add(performance);
		}
		return performanceList;
	}
	
		
		
	//検索処理（ID）
	public Performance getPById(int performanceID)  {

		String sql = "SELECT * FROM performance WHERE performanceid = ?";
		Map<String, Object> onePerformance = jdbcTemplate.queryForMap(sql, performanceID);
		 
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			
		Performance performance = new Performance(
	                (int) onePerformance.get("performanceid")
	                ,(int) onePerformance.get("userid")
	                ,(int) onePerformance.get("categoryid")
	                ,(int) onePerformance.get("amount")
	                ,date.format(onePerformance.get("date"))
		);
			return performance;
	}



	//変更処理
	public boolean changeP(Performance p)  {
		boolean result = false;
	
		String sql = "UPDATE performance SET categoryid = ?, amount = ?, date =? WHERE performanceid = ?";
		jdbcTemplate.update(sql, p.getCategoryID(), p.getAmount(), Date.valueOf(p.getDate()) ,p.getPerformanceID());
		//
		result = true;
		//
		return result;
	}
		
		
		
	//削除処理
	public boolean deleteP(int performanceID)  {
		boolean result = false;
		
		String sql = "DELETE FROM performance WHERE performanceid = ? ";
		jdbcTemplate.update(sql, performanceID);
		//
		result = true;
		//
		return result;
	}
}
