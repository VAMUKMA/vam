package ukma.vam.edsystem.dao.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukma.vam.edsystem.entity.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUser_id(rs.getLong("user_id"));
		user.setEmail(rs.getString("email"));
		user.setRole(rs.getString("role"));
		user.setPassword(rs.getString("password"));
		user.setPoints(rs.getInt("points"));
		
		return user;
	}
}
