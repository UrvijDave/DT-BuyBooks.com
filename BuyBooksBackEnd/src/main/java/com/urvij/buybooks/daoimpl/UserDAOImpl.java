
package com.urvij.buybooks.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.urvij.buybooks.dao.UserDAO;
import com.urvij.buybooks.model.User;

public class UserDAOImpl implements UserDAO {

	// you required session factory --> in application context config

	@Autowired
	public SessionFactory sessionFactory;

	// How to get initialize

	// At the time of creation of instance, you have to pass sessionFactory

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User get(String id) {

		return (User) sessionFactory.getCurrentSession().get(User.class,id); // primary key should not return more than one raw
		
	}

	public User validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(User user) {

		try {

			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(User user) {

		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
