/*package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.dao.UserDAO;
import com.spring.model.Users;

@Controller
public class RegistrationController {
	

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/")
	public String landPage(@ModelAttribute("Users")Users users,BindingResult result,Model model)
	{
		return "index";
		
	}
	

	@RequestMapping(value="/register")
	public String registrationPage(Model model)
	{
		model.addAttribute("users", new Users());
		return "registration";
		
	}
	 
	
	 
	
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
public String addUser(@ModelAttribute("users")Users users)
{
		
		users.setRole("ROLE_USER");
		userDAO.saveUser(users);
		
		return "redirect:/";
		
	}
}
	
	


*/