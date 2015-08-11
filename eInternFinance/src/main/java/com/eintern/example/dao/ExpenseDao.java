package com.eintern.example.dao;

import java.util.ArrayList;

import com.eintern.example.entity.Expense;

public interface ExpenseDao {



	// create expense
	void save(Expense expense);

	// modify expense
	void modify(Expense expense);

	// delete expense
	void delete(Expense expense);
	
	ArrayList<Expense> getExpenses();
	
	ArrayList<Expense> getExpensesByCategory(String category);
	
	Expense findByID(int id);
	
	

}
