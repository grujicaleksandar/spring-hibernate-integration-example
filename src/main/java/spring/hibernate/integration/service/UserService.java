package spring.hibernate.integration.service;

import java.util.List;

import spring.hibernate.integration.model.User;

public interface UserService {

	List<User> getAll();
	
}
