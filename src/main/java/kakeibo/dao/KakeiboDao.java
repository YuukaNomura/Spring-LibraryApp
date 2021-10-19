//package kakeibo.dao;
//
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import kakeibo.entity.Budget;
//import kakeibo.entity.Performance;
//
//@Repository
//public class KakeiboDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
	
	
	//ユーザー取得
//	public User getUser(int userId)  {
//		String sql = "SELECT * FROM useres WHERE userid = ?";
//		Map<String, Object> oneUser = jdbcTemplate.queryForMap(sql, userId);	
//		User user = new User((int) oneUser.get("userid"),(String) oneUser.get("userpassword"));
//        return user;
//	}
	
	
	
	//カテゴリー取得
//	public ArrayList<Category> getCategoryList() {
//
//		String sql = "SELECT * FROM category";
//		
//		List<Map<String, Object>> categorys = jdbcTemplate.queryForList(sql);
//		ArrayList<Category> categoryList = new ArrayList<Category>();
//
//		for (Map<String, Object> eachCategory : categorys) {
//		     Category category = new Category(
//		    		 (int) eachCategory.get("categoryid")
//	                ,(String) eachCategory.get("categoryname")
//	                ,(int) eachCategory.get("bop"));
//		     categoryList.add(category);
//		}
//		return categoryList;
//	}
	
	
	
	//登録処理
//	public boolean inputP(Performance p)  {
//		//ID自動採番処理
//		String sql1 = "SELECT MAX(performanceid) FROM performance";
//		Map<String, Object> performance = jdbcTemplate.queryForMap(sql1);
//
//		int performanceId = (int) performance.get("max");
//		p.setPerformanceID(++performanceId);
//
//		//DB新規登録処理
//		boolean result = false;
//		String sql2 = "INSERT INTO performance VALUES (?, ?, ?, ?, ?)";
//		jdbcTemplate.update(sql2,
//			p.getPerformanceID(),p.getUserID(),p.getCategoryID(),p.getAmount(), Date.valueOf(p.getDate()));
//			
//		//登録確認処理
//		String sql3 = "SELECT * FROM performance WHERE performanceid = ?";
//		Map<String, Object> performance2 = jdbcTemplate.queryForMap(sql3, p.getPerformanceID());
//
//		if(performance2 != null) {
//			result = true;
//		}
//	        return result;
//		}
//		
//		
//		
//	//検索処理（日付）
//	public List<Performance> getPByDate(int userID, String date)  {
//
//		String sql = "SELECT * FROM performance WHERE (userid = ? AND date = ?) ";
//
//		List<Map<String, Object>> performances = jdbcTemplate.queryForList(sql, userID,Date.valueOf(date));
//		List<Performance> performanceList = new ArrayList<Performance>();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//
//		for(Map<String, Object> eachPerformance: performances) {
//			Performance performance = new Performance(
//	                    (int) eachPerformance.get("performanceid")
//	                    ,(int) eachPerformance.get("userid")
//	                    ,(int) eachPerformance.get("categoryid")
//	                    ,(int) eachPerformance.get("amount")
//	                    ,sdf.format(eachPerformance.get("date"))
//			);
//			performanceList.add(performance);
//		}
//	        return performanceList;
//	}
//	
//		
//		
//	//検索処理（ID）
//	public Performance getPById(int performanceID)  {
//
//		String sql = "SELECT * FROM performance WHERE performanceid = ?";
//		Map<String, Object> onePerformance = jdbcTemplate.queryForMap(sql, performanceID);
//		 
//		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//			
//		Performance performance = new Performance(
//	                (int) onePerformance.get("performanceid")
//	                ,(int) onePerformance.get("userid")
//	                ,(int) onePerformance.get("categoryid")
//	                ,(int) onePerformance.get("amount")
//	                ,date.format(onePerformance.get("date"))
//		);
//			return performance;
//	}
//
//
//
//	//変更処理
//	public boolean changeP(Performance p)  {
//		boolean result = false;
//	
//		String sql = "UPDATE performance SET categoryid = ?, amount = ?, date =? WHERE performanceid = ?";
//		jdbcTemplate.update(sql, p.getCategoryID(), p.getAmount(), Date.valueOf(p.getDate()) ,p.getPerformanceID());
//		//
//		result = true;
//		//
//		return result;
//	}
//		
//		
//		
//	//削除処理
//	public boolean deleteP(int performanceID)  {
//		boolean result = false;
//		
//		String sql = "DELETE FROM performance WHERE performanceid = ? ";
//		jdbcTemplate.update(sql, performanceID);
//		//
//		result = true;
//		//
//		return result;
//	}
//	
//	
//	
//	//目標額登録
//	public boolean inputB (Budget b) {
//		boolean result = false;
//		
//		//すでに登録されているか確認
//		String sql1 = "SELECT * FROM budget WHERE (date = ? AND userid = ?)";
//		List<Map<String, Object>> Budgets = jdbcTemplate.queryForList(sql1, Date.valueOf(b.getDate()),b.getUserID());
//		
//		if(Budgets.size() == 0) {
//		
//			//DB新規登録処理
//			String sql2 = "INSERT INTO budget VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			jdbcTemplate.update(sql2,
//					Date.valueOf(b.getDate()),b.getUserID(),b.getAmount1(),b.getAmount2(), 
//					b.getAmount3(),b.getAmount4(),b.getAmount5(),b.getAmount6(),b.getAmount7(),
//					b.getAmount8(),b.getAmount9(),b.getAmount10(),b.getAmount11());
//		
//			result = true;
//		
//		} else {
//			
//			//DB更新処理
//			String sql2 = "UPDATE budget SET amount1 = ?, amount2 = ?, amount3 = ?, "
//					+ "amount4 = ?, amount5 = ?, amount6 = ?, amount7 = ?, amount8 = ?, "
//					+ "amount9 = ?, amount10 = ?, amount11 = ? WHERE date = ? AND userid = ?";
//			jdbcTemplate.update(sql2,
//				b.getAmount1(),b.getAmount2(), b.getAmount3(),b.getAmount4(),b.getAmount5(),b.getAmount6(),b.getAmount7(),
//				b.getAmount8(),b.getAmount9(),b.getAmount10(),b.getAmount11(), Date.valueOf(b.getDate()),b.getUserID());
//			
//			result = true;
//		}
//		
//		return result;
//	}
//	
//	
//	
//	//目標額検索
//	public Budget getB(String date, int userID)  {
//
//		String sql = "SELECT * FROM budget WHERE (date = ? AND userid = ?)";
//
//		Map<String, Object> oneBudget = jdbcTemplate.queryForMap(sql, Date.valueOf(date), userID);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//
//		Budget budget = new Budget(
//				sdf.format(oneBudget.get("date"))
//                ,(int) oneBudget.get("userid")
//                ,(int) oneBudget.get("amount1")
//                ,(int) oneBudget.get("amount2")
//                ,(int) oneBudget.get("amount3")
//                ,(int) oneBudget.get("amount4")
//                ,(int) oneBudget.get("amount5")
//                ,(int) oneBudget.get("amount6")
//                ,(int) oneBudget.get("amount7")
//                ,(int) oneBudget.get("amount8")
//                ,(int) oneBudget.get("amount9")
//                ,(int) oneBudget.get("amount10")
//                ,(int) oneBudget.get("amount11")
//         );
//		return budget;
//	}
//	
//	
//
//}
