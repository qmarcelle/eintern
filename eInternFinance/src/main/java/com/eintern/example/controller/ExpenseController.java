package com.eintern.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eintern.example.entity.Expense;
import com.eintern.example.service.ExpenseService;
import com.eintern.example.service.IncomeService;
import com.pingunaut.wicket.chartjs.chart.impl.Pie;
import com.pingunaut.wicket.chartjs.core.panel.PieChartPanel;
import com.pingunaut.wicket.chartjs.data.PieChartData;

@Controller
/*@SessionAttributes("expense")*/
public class ExpenseController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ExpenseService expenseService;
	
	
	
	@InitBinder
	public void binder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	

	
	
	//displays page regularly works!
	@RequestMapping(value = "/expense", method = RequestMethod.GET)
	public String expense(Model model){
	
		Expense expense = new Expense();
		model.addAttribute("expenses",expenseService.getExpenses());
		
		
		
		
		model.addAttribute("expense", expense);
		//request.setAttribute("expenses", expenseService.getExpenses());
		
		
	
		
		
		
		
		return "expense/expense";
	}
	
	
/*	//display add expense
	@RequestMapping(value = "/addexpenses", method = RequestMethod.GET)
	public String manageExpenses(Model model){
		
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
	
		//model.addAttribute( "expense_jargon", " Here are your expenses");
		System.out.println("created expense model");
		
		return "expense/managexpenses";
	}
	*/
	
	//edit expense works!
	@RequestMapping(value = "/editexpenses", method = RequestMethod.GET)
	public String editExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){
		System.out.println(expense.toString());
		
		if(result.hasErrors()){
			//return to the expense page with the error
			return "expense/expense";
		}
		else{
			System.out.println("successfully binded" + expense.toString());
			//add the proper id
			System.out.println("current model id is " + expense.getiD());
			/*System.out.println("id = " + id);*/
			//expense.setiD(id);
			//modify the expense object
			expenseService.modify(expense);
			 //expenseService.save(expense);
				// if save is successful save get the model again to send to the view
			 request.setAttribute("expenses", expenseService.getExpenses());
		}
		return "expense/expense";
	}	
	
	
	//add expense works!
	@RequestMapping(value = "/managexpenses", method = RequestMethod.POST)
	public String getAddExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){
		
		System.out.println(expense.toString());
		
		if(result.hasErrors()){
			return "expense/expense";
		}
		else{
			//save the expense object
			 expenseService.save(expense);
				// if save is successful save get the model again to send to the view
			 request.setAttribute("expenses", expenseService.getExpenses());
		}
		return "expense/expense";
	}	
	
	
	
	//delete expense works!
	@RequestMapping(value="/deleteExpense", method= RequestMethod.GET)
	public String deleteExpenses(@RequestParam("id")int id, Model model /*@ModelAttribute("expense")Expense expense*/){
		
		System.out.println("id is set to: " + id);
		Expense expense = new Expense();
		
		expense.setiD(id);
		
		model.addAttribute("expense",expense);
		
		System.out.println("expenses id is set to "+ expense.getiD());
		//pass in the expense with the id
		expenseService.delete(expense);
		//reload model
		 request.setAttribute("expenses", expenseService.getExpenses());
		//redirect to the same page
		 System.out.println(expenseService.getExpenses());
		return "expense/expense";
	}
	
	
}
