//package kakeibo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import kakeibo.dao.KakeiboDao;
//import kakeibo.entity.Budget;
//import kakeibo.entity.Category;
//import kakeibo.entity.Performance;
//import kakeibo.entity.PerformanceForm;
//
//@Service
//@Transactional
//public class KakeiboService {
//	
//	@Autowired
//	private KakeiboDao kakeiboDao;
//	
//	
//	
//	//ログインチェック
//	@Transactional(readOnly = true)
//	public int checkLogin(User u) {
//		
//		int userID = 0;
//		User user = kakeiboDao.getUser(u.getUserID());
//			
//		if(user != null && u.getUserPassword().equals(user.getUserPassword())) {
//			userID = u.getUserID();
//		} 
//		return userID;
//	}
	
	
	
	//カテゴリー取得
//	@Transactional(readOnly = true)
//	public ArrayList<Category> getCategory() {
//
//		ArrayList<Category> categoryList = new ArrayList<Category>();
//		categoryList = kakeiboDao.getCategoryList();
//
//		return categoryList;
//	}
//	
//	
//	
//	//登録
//	public boolean inputPerformance(Performance p, int userID) {
//		
//		boolean result = false;	
//		p.setUserID(userID);
//		result = kakeiboDao.inputP(p);
//
//		return result;
//	}
//		
//		
//	
//	//検索
//	@Transactional(readOnly = true)
//	public List<PerformanceForm> getPerformance(Performance p, int userID, ArrayList<Category> categoryList) {
//		
//		p.setUserID(userID);
//		List<Performance> performanceList = kakeiboDao.getPByDate(p.getUserID(), p.getDate());
//		
//		String categoryName = null;
//		List<PerformanceForm> performanceForm = new ArrayList<PerformanceForm>();
//		
//		
//		for(Performance eachPerformance: performanceList) {
//			
//			for(Category eachcategory: categoryList) {
//				if(eachPerformance.getCategoryID() == eachcategory.getCategoryID()) {
//					categoryName = eachcategory.getCategoryName();
//				}
//			}
//			PerformanceForm pf = new PerformanceForm(
//					eachPerformance.getPerformanceID(),
//					categoryName,
//					eachPerformance.getAmount(),
//					eachPerformance.getDate()
//					);
//			performanceForm.add(pf);
//		}
//
//		return performanceForm;
//	}
//		
//		
//	
//	//変更
//	@Transactional(readOnly = true)
//	public Performance getPerformanceById(Performance p) {
//
//		Performance performance = kakeiboDao.getPById(p.getPerformanceID());
//		return performance;
//	}
//		
//	public boolean changePerformance(Performance p) {
//
//		boolean result = false;	
//		result = kakeiboDao.changeP(p);
//
//		return result;
//	}
//		
//		
//	
//	//削除
//	public boolean deletePerformance(Performance p) {
//			
//		int performanceID = p.getPerformanceID();
//		boolean result = false;	
//		result = kakeiboDao.deleteP(performanceID);
//
//		return result;
//	}
//	
//	
//	
//	//目標額登録
//	public boolean inputBudget(Budget b, int userID) {
//
//		boolean result = false;	
//		
//		b.setUserID(userID);
//		String date = b.getDate();
//		date = date + "-01";
//		b.setDate(date);
//	
//		result = kakeiboDao.inputB(b);
//
//		return result;
//	}
//	
//	
//	
//	//目標額検索
//	@Transactional(readOnly = true)
//	public Budget getBudget(Budget b, int userID) {
//		
//		b.setUserID(userID);
//		String date = b.getDate();
//		date = date + "-01";
//		b.setDate(date);
//		
//		Budget budget = kakeiboDao.getB(date,userID);
//		List<Performance> performanceList = kakeiboDao.getPByDate(userID, date);
//
//		return budget;
//	}
//
//}
