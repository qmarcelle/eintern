package com.eintern.example.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eintern.example.entity.Expense;

@Repository("expenseRepository")
public class ExpenseDaoImpl implements ExpenseDao {

	@Autowired
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void save(Expense expense) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(expense);


	}

	@Override
	@Transactional
	public void modify(Expense expense) {
	
		sessionFactory.getCurrentSession().update(expense);
	}

	@Override
	@Transactional
	public void delete(Expense expense) {
		//find the item in the table
	Expense deleteMe = (Expense) sessionFactory.getCurrentSession().get(Expense.class, expense.getiD());
	//remove it
	sessionFactory.getCurrentSession().delete(deleteMe);
	}

	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public ArrayList<Expense> getExpenses() {
		
		ArrayList<Expense> list = (ArrayList<Expense>) sessionFactory.getCurrentSession().createCriteria(Expense.class) .list(); 

		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public Expense findByID(int id) {
		// TODO Auto-generated method stub
		Expense ex = (Expense) sessionFactory.getCurrentSession().get ( Expense.class, id);
		return ex;
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public ArrayList<Expense> getExpensesByCategory(String category) {
		ArrayList<Expense> list = (ArrayList<Expense>) sessionFactory.getCurrentSession().createCriteria(Expense.class)
				.add(Restrictions.eq("category", category))
				.list(); 

		return list;
	}

}
