package com.eintern.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		System.out.println("In the login method");

		return "login";

	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String landingPage(ModelMap model) {

		System.out.println("landing page");

		return "index";

	}
	
	

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error403(ModelMap model) {
		return "error/403";
	}
}
