package com.eintern.example.service;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eintern.example.dao.UserDao;
import com.eintern.example.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	private UserDao user;

	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

/*	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}*/

/*	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

/*	@Transactional
	public void save(User user) {
		return (Long) sessionFactory.getCurrentSession().save(user);
	}*/

/*	@Transactional(readOnly = true)
	public User getUserByName(String name) {
		return (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class).add(Restrictions.eq("name", name))
				.uniqueResult();
	}

	@Transactional
	public void deleteById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		delete((User) s.get(User.class, id));
	}

	@Transactional
	public void delete(User u) {
		sessionFactory.getCurrentSession().delete(u);
	}*/
	
	
}
