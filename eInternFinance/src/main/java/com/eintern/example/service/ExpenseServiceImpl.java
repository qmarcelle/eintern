package com.eintern.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintern.example.dao.ExpenseDao;
import com.eintern.example.entity.Expense;

@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {

	
	@Autowired
	private ExpenseDao expenseDao;
	
	
	@Override
	public void save(Expense expense) {
		// TODO Auto-generated method stub
		
		System.out.println(expense.toString());
		
		 expenseDao.save(expense);
	}

	@Override
	public void modify(Expense expense) {
		// TODO Auto-generated method stub
		expenseDao.modify(expense);
	}

	@Override
	public void delete(Expense expense) {
		// TODO Auto-generated method stub
		
		expenseDao.delete(expense);
	}

	@Override
	public ArrayList<Expense> getExpenses() {
		 
		return expenseDao.getExpenses();
	}

	@Override
	public ArrayList<Expense> getProjectExpenses() {
		
		return expenseDao.getExpensesByCategory("Projects");
	}

	
	@Override
	public ArrayList<Expense> getResourcesExpenses() {
		
		return expenseDao.getExpensesByCategory("Resources");
	}

	@Override
	public ArrayList<Expense> getTravelExpenses() {
		
		return expenseDao.getExpensesByCategory("Travel");
	}

	@Override
	public ArrayList<Expense> getUtilitiesExpenses() {
		
		return expenseDao.getExpensesByCategory("Utilities");
	}

	@Override
	public ArrayList<Expense> getMarketingExpenses() {
		
		return expenseDao.getExpensesByCategory("Marketing");
	}

	@Override
	public ArrayList<Expense> getOtherExpenses() {
		
		return expenseDao.getExpensesByCategory("Other Activities");
	}

	//get the total
	@Override
	public Double total(List<Expense> expense) {
		Double total = (double) 0;
		
		for(Expense elem:expense){
			total+=elem.getAmmount();
		}
		return total;
	}

}
