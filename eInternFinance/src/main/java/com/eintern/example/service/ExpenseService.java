package com.eintern.example.service;

import java.util.ArrayList;
import java.util.List;

import com.eintern.example.entity.Expense;

public interface ExpenseService {
	
	//create expense
	void save(Expense expense);
	
	//modify expense
	void modify(Expense expense);
	
	//delete expense
	void delete(Expense expense);
	
	//view specific
	
	//view all
	
	ArrayList<Expense> getExpenses();
	
	
	//get expenses by category
	ArrayList<Expense> getProjectExpenses();
	
	ArrayList<Expense> getResourcesExpenses();
	
	ArrayList<Expense> getTravelExpenses();
	
	ArrayList<Expense> getUtilitiesExpenses();
	
	ArrayList<Expense> getMarketingExpenses();
	
	ArrayList<Expense> getOtherExpenses();
	
	
	//get totals
	Double total(List<Expense> expense);

}
