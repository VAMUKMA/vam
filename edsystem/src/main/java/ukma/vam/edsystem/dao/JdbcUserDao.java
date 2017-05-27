package ukma.vam.edsystem.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ukma.vam.edsystem.dao.orm.UserMapper;
import ukma.vam.edsystem.entity.User;

@Repository
public class JdbcUserDao implements UserDao{
	
	private static final String SQL_INSERT_USER = "INSERT INTO users(email, password, points, role) VALUES (?, ?, 0, 'user')";

	private static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
	
	private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
	
	private static final String SQL_UPDATE_USER_PASSWORD = "UPDATE users SET password = ? WHERE user_id = ?";
	
	private static final String SQL_UPDATE_USER_POINTS = "UPDATE users SET points = ? WHERE user_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUserByEmail(String email) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_BY_EMAIL, new UserMapper(), email);
	}

	@Override
	public User getUserById(long id) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, new UserMapper(), id);
	}

	@Override
	public void create(User user) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_INSERT_USER);
		
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		
		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_UPDATE_USER_PASSWORD);
		
		ps.setString(1, user.getPassword());
		ps.setLong(2, user.getUser_id());
		
		ps.executeUpdate();
		ps.close();
	}
	
	@Override
	public void updatePoints(User user) throws SQLException {

		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection().prepareStatement(SQL_UPDATE_USER_POINTS);
		
		ps.setInt(1, user.getPoints());
		ps.setLong(2, user.getUser_id());
		
		ps.executeUpdate();
		ps.close();
	}

}
