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
	public User getUser(int userId)  {
		String sql = "SELECT * FROM users WHERE userid = ?";
		Map<String, Object> oneUser = jdbcTemplate.queryForMap(sql, userId);

		User user = new User();
		if(oneUser!=null) {
			user.setUserID((int) oneUser.get("userid"));
			user.setUserPassword((String) oneUser.get("userpassword"));
		}
        return user;
	}
}
