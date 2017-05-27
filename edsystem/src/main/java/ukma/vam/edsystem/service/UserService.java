package ukma.vam.edsystem.service;

import java.sql.SQLException;

import ukma.vam.edsystem.entity.User;

public interface UserService {

	public User getUserByEmail(String email);
	
	public User getUserById(long id);
	
	public void create(User user) throws SQLException;
	
	public void updatePassword(User user) throws SQLException;
	
	public void updatePoints(User user) throws SQLException;
}
