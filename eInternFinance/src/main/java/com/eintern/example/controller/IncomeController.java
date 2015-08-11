package com.eintern.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eintern.example.entity.Expense;
import com.eintern.example.entity.Income;
import com.eintern.example.service.ExpenseService;
import com.eintern.example.service.IncomeService;

@Controller
public class IncomeController {
	
	
	@Autowired
	private IncomeService incomeService;
	
	
	@Autowired
	private HttpServletRequest request;
	
	@InitBinder
	public void binder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	
	
/*	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homepage(Model model){*/
	
		//Expense expense = new Expense();
		//model.addAttribute("expenses", /*expense*/expenseService.getExpenses());
		//model.addAttribute("expense", expense);
		//request.setAttribute("expenses", expenseService.getExpenses());
		
		
		/*return "home/home";
	}*/
	
	
	//displays page regularly works!
	@RequestMapping(value = "/income", method = RequestMethod.GET)
	public String expense(Model model){
	
		Income income = new Income();
		model.addAttribute("incomes", /*expense*/incomeService.getIncomes());
		model.addAttribute("income", income);
		//request.setAttribute("expenses", expenseService.getExpenses());
		
		
		return "income/income";
	}
	

	
	//edit expense works!
	@RequestMapping(value = "/editincomes", method = RequestMethod.GET)
	public String editExpense(@Valid @ModelAttribute("income") Income income, BindingResult result){
		System.out.println(income.toString());
		
		if(result.hasErrors()){
			//return to the expense page with the error
			return "income/income";
		}
		else{
			System.out.println("successfully binded" + income.toString());
			//add the proper id
			System.out.println("current model id is " + income.getiD());
			/*System.out.println("id = " + id);*/
			//expense.setiD(id);
			//modify the expense object
			incomeService.modify(income);
			 //expenseService.save(expense);
				// if save is successful save get the model again to send to the view
			 request.setAttribute("incomes", incomeService.getIncomes());
		}
		return "income/income";
	}	
	
	
	//add expense works!
	@RequestMapping(value = "/manageincomes", method = RequestMethod.POST)
	public String getAddExpense(@Valid @ModelAttribute("income") Income income, BindingResult result){
		
		System.out.println(income.toString());
		
		if(result.hasErrors()){
			return "imncome/income";
		}
		else{
			//save the expense object
			incomeService.save(income);
				// if save is successful save get the model again to send to the view
			 request.setAttribute("incomes", incomeService.getIncomes());
		}
		return "income/income";
	}	
	
	
	
	//delete expense works!
	@RequestMapping(value="/deleteIncome", method= RequestMethod.GET)
	public String deleteExpenses(@RequestParam("id")int id, Model model /*@ModelAttribute("expense")Expense expense*/){
		
		System.out.println("id is set to: " + id);
		Income income = new Income();
		
		income.setiD(id);
		
		model.addAttribute("income",income);
		
		System.out.println("expenses id is set to "+ income.getiD());
		//pass in the expense with the id
		incomeService.delete(income);
		//reload model
		 request.setAttribute("incomes",incomeService.getIncomes());
		//redirect to the same page
		 System.out.println(incomeService.getIncomes());
		return "income/income";
	}
	
	

}
