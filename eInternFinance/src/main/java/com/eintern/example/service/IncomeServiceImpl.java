package com.eintern.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintern.example.dao.IncomeDao;
import com.eintern.example.entity.Expense;
import com.eintern.example.entity.Income;

@Service("incomeService")
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeDao incomeDao;

	@Override
	public ArrayList<Income> getIncomes() {
		// TODO Auto-generated method stub
		return incomeDao.getIncomes();
	}

	@Override
	public void save(Income income) {
		// TODO Auto-generated method stub
		incomeDao.save(income);

	}

	@Override
	public void modify(Income income) {
		// TODO Auto-generated method stub
		incomeDao.modify(income);

	}

	@Override
	public void delete(Income income) {
		// TODO Auto-generated method stub
		incomeDao.delete(income);

	}
	
	@Override
	public ArrayList<Income> getConsultationIncomes() {
		// TODO Auto-generated method stub
		return incomeDao.getIncomesByCategory("Consultation");
	}

	@Override
	public ArrayList<Income> getIntensiveIncomes() {
		// TODO Auto-generated method stub
		return incomeDao.getIncomesByCategory("Intensive Session");
	}

	@Override
	public ArrayList<Income> getSeminarIncomes() {
		// TODO Auto-generated method stub
		return incomeDao.getIncomesByCategory("Seminars");
	}

	@Override
	public ArrayList<Income> getMediasalesIncomes() {
		// TODO Auto-generated method stub
		return incomeDao.getIncomesByCategory("Media Sales");
	}

	@Override
	public Double total(List<Income> income) {
		// TODO Auto-generated method stub
		Double total =(double) 0;
		for(Income inc: income){
			total+=inc.getAmmount();
		}
		
		return total;
	}

	
	
	

}
