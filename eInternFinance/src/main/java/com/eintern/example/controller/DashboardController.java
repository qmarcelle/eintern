package com.eintern.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eintern.example.service.ExpenseService;
import com.eintern.example.service.IncomeService;

@Controller
public class DashboardController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private IncomeService incomeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Model model) {

		model.addAttribute("totalExpenses", expenseService.total(expenseService.getExpenses()));

		model.addAttribute("totalProjects", expenseService.total(expenseService.getProjectExpenses()));

		model.addAttribute("totalResources", expenseService.total(expenseService.getResourcesExpenses()));
		model.addAttribute("totalTravel", expenseService.total(expenseService.getTravelExpenses()));
		model.addAttribute("totalUtilities", expenseService.total(expenseService.getUtilitiesExpenses()));
		model.addAttribute("totalMarketing", expenseService.total(expenseService.getMarketingExpenses()));
		model.addAttribute("totalOther", expenseService.total(expenseService.getOtherExpenses()));

		model.addAttribute("totalConsult", incomeService.total(incomeService.getConsultationIncomes()));
		model.addAttribute("totalIntensive", incomeService.total(incomeService.getIntensiveIncomes()));
		model.addAttribute("totalSeminar", incomeService.total(incomeService.getSeminarIncomes()));
		model.addAttribute("totalMedia", incomeService.total(incomeService.getMediasalesIncomes()));

		
		model.addAttribute("totalIncome", incomeService.total(incomeService.getIncomes()));
		return "home/home";
	}

}
