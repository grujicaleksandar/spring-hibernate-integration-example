package spring.hibernate.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.hibernate.integration.dao.UserDao;
import spring.hibernate.integration.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	public List<User> getAll() {
		
		List<User> users = userDao.getAll();
		
		return users;
		
	}

}
