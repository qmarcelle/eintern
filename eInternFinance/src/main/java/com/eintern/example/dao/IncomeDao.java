package com.eintern.example.dao;

import java.util.ArrayList;

import com.eintern.example.entity.Income;

public interface IncomeDao {

	// create expense
	void save(Income income);

	// modify expense
	void modify(Income income);

	// delete expense
	void delete(Income income);
	
	ArrayList<Income> getIncomes();
	
	
	ArrayList<Income> getIncomesByCategory(String category);
	
	Income findByID(int id);
}
