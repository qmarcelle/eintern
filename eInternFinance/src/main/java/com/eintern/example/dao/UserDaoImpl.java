package com.eintern.example.dao;

import com.eintern.example.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	

	public void save(User user) {
	  sessionFactory.getCurrentSession().save(user);
	}


	public User getUserByName(String name) {
		return (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class).add(Restrictions.eq("name", name))
				.uniqueResult();
	}


	public void deleteById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		delete((User) s.get(User.class, id));
	}


	public void delete(User u) {
		sessionFactory.getCurrentSession().delete(u);
	}
	
}
