package ukma.vam.edsystem.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ukma.vam.edsystem.dao.UserDao;
import ukma.vam.edsystem.entity.User;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void create(User user) throws SQLException {
		userDao.create(user);
	}

	@Override
	public void updatePassword(User user) throws SQLException {
		userDao.updatePassword(user);
	}

	@Override
	public void updatePoints(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
