package in.lingtan.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.lingtan.model.User;

@Repository
public class UserJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<User> getCredentialData() {
		String sql = "Select username, password from user_data";
		return jdbcTemplate.query(sql, (ResultSet rs) -> {
			List<User> userCredentials = new ArrayList<>();
			while (rs.next()) {

				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setUserName(username);
				user.setPassword(password);
				userCredentials.add(user);

			}
			return userCredentials;
		});
	}

}
