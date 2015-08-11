package com.eintern.example.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eintern.example.entity.Income;



@Repository("incomeRepository")
public class IncomeDaoImpl implements IncomeDao{
	
	
	
	@Autowired
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public ArrayList<Income> getIncomes() {
		ArrayList<Income> list = (ArrayList<Income>) sessionFactory.getCurrentSession().createCriteria(Income.class) .list(); 

		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public Income findByID(int id) {
		Income in = (Income) sessionFactory.getCurrentSession().get ( Income.class, id);
		return in;
	}

	@Override
	@Transactional
	public void save(Income income) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(income);
	}

	@Override
	@Transactional
	public void modify(Income income) {
		sessionFactory.getCurrentSession().update(income);
		
	}

	@Override
	@Transactional
	public void delete(Income income) {
		Income deleteMe = (Income) sessionFactory.getCurrentSession().get(Income.class, income.getiD());
		//remove it
		sessionFactory.getCurrentSession().delete(deleteMe);
		
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public ArrayList<Income> getIncomesByCategory(String category) {
		ArrayList<Income> list = (ArrayList<Income>) sessionFactory.getCurrentSession().createCriteria(Income.class)
				.add(Restrictions.eq("category", category))
				.list(); 

		return list;
	}

}
