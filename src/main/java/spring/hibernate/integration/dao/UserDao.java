package spring.hibernate.integration.dao;

import java.util.List;

import spring.hibernate.integration.model.User;

public interface UserDao {

	List<User> getAll();
	
}
