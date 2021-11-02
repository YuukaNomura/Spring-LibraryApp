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
	public User checkLogin(User u) {
			
		String userID = null;
		User user = userDao.getUser(u.getId());
				
		if(user != null && u.getPass().equals(user.getPass())) {
			userID = u.getId();
		} 
		return user;
	}

}
