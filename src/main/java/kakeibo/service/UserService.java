package kakeibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kakeibo.dao.UserDao;
import kakeibo.entity.User;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private UserDao userDao;
	

	//ログインチェック
	@Transactional(readOnly = true)
	public int checkLogin(User u) {
			
		int userID = 0;
		User user = userDao.getUser(u.getUserID());
				
		if(user != null && u.getUserPassword().equals(user.getUserPassword())) {
			userID = u.getUserID();
		} 
		return userID;
	}

}
