package kakeibo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kakeibo.dao.CategoryDao;
import kakeibo.entity.Category;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	
	//カテゴリー取得
	@Transactional(readOnly = true)
	public ArrayList<Category> getCategory() {

		ArrayList<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryDao.getCategoryList();

		return categoryList;
	}

}
