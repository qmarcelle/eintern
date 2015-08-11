package com.eintern.example.service;

import java.util.ArrayList;
import java.util.List;

import com.eintern.example.entity.Expense;
import com.eintern.example.entity.Income;

public interface IncomeService {

	// create income
	void save(Income income);

	// modify income
	void modify(Income income);

	// delete income
	void delete(Income income);
	
	//view all
	ArrayList<Income> getIncomes();
	
	
	//categories
	ArrayList<Income> getConsultationIncomes();
	ArrayList<Income> getIntensiveIncomes();
	ArrayList<Income> getSeminarIncomes();
	ArrayList<Income> getMediasalesIncomes();
	
	
	//get totals
		Double total(List<Income> income);
	

}
