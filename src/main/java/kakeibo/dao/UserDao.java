package kakeibo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kakeibo.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//ユーザー取得
	public User getUser(String userId)  {
		
/*		String sql = "SELECT * FROM users WHERE userid = ?";
		Map<String, Object> oneUser = jdbcTemplate.queryForMap(sql, userId);

		User user = new User();*/
		
		final String sql = "select * from user where id=?;";
		Map<String, Object> oneUser = jdbcTemplate.queryForMap(sql, userId);
		User resultUser = null;	
		
		if(oneUser!=null) {
			resultUser = new User((String) oneUser.get("id"), (String) oneUser.get("pass"),(String) oneUser.get("name"));
			//user.setUserID((int) oneUser.get("userid"));
			//user.setUserPassword((String) oneUser.get("userpassword"));
		}
        return resultUser;
	}
}
