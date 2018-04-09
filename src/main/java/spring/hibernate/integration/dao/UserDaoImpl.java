package spring.hibernate.integration.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.hibernate.integration.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> getAll() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("select u from User u",User.class);
		
		List<User> users = query.getResultList();
		
		return users;
		
		
	}

}
