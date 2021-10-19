package kakeibo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kakeibo.dao.PerformanceDao;
import kakeibo.entity.Category;
import kakeibo.entity.Performance;
import kakeibo.entity.PerformanceForm;

@Service
@Transactional(rollbackFor = Exception.class)
public class PerformanceService {

	@Autowired
	private PerformanceDao performanceDao;
	
	
	//登録
	public boolean inputPerformance(Performance performance) {
		
		boolean result = false;	
		result = performanceDao.inputP(performance);
		return result;
	}
		
		
	//検索
	@Transactional(readOnly = true)
	public List<PerformanceForm> getPerformance(int userID, String date, ArrayList<Category> categoryList) {
		
		List<Performance> performanceList = performanceDao.getPByDate(userID, date);
		
		String categoryName = null;
		List<PerformanceForm> performanceForm = new ArrayList<PerformanceForm>();
		
		
		for(Performance eachPerformance: performanceList) {
			
			for(Category eachcategory: categoryList) {
				if(eachPerformance.getCategoryID() == eachcategory.getCategoryID()) {
					categoryName = eachcategory.getCategoryName();
				}
			}
			PerformanceForm pf = new PerformanceForm(
					eachPerformance.getPerformanceID(),
					categoryName,
					eachPerformance.getAmount(),
					eachPerformance.getDate()
					);
			performanceForm.add(pf);
		}

		return performanceForm;
	}
	
	
	@Transactional(readOnly = true)
	public List<Performance> getPerformanceByDate(int userID, String date) {

		List<Performance> performances = performanceDao.getPByDate(userID, date);
		
		return performances;
	}
	
	
	@Transactional(readOnly = true)
	public ArrayList<Performance> getPerformanceGroupByCategory(int userID, String date) {

		ArrayList<Performance> performances = performanceDao.getPGroupByCategory(userID, date);
		
		return performances;
	}
	
	
	//変更
	@Transactional(readOnly = true)
	public Performance getPerformanceById(int performanceID) {

		Performance performance = performanceDao.getPById(performanceID);
		return performance;
	}
	
	public boolean changePerformance(Performance p) {

		boolean result = false;	
		result = performanceDao.changeP(p);

		return result;
	}
		
		
	//削除
	public boolean deletePerformance(int performanceID) {
			
		boolean result = false;	
		result = performanceDao.deleteP(performanceID);

		return result;
	}
}
