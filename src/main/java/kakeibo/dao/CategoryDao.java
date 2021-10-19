package kakeibo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kakeibo.entity.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//カテゴリー取得
	public ArrayList<Category> getCategoryList() {

		String sql = "SELECT * FROM category";
		
		List<Map<String, Object>> categorys = jdbcTemplate.queryForList(sql);
		ArrayList<Category> categoryList = new ArrayList<Category>();

		for (Map<String, Object> eachCategory : categorys) {
		     Category category = new Category(
		    		 (int) eachCategory.get("categoryid")
	                ,(String) eachCategory.get("categoryname")
	                ,(int) eachCategory.get("bop"));
		     categoryList.add(category);
		}
		return categoryList;
	}
		
}
