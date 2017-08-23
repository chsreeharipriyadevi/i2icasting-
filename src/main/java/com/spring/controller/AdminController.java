/*package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.CategoryDaAO;
import com.spring.model.Category;

@Controller
public class AdminController 
{
	@Autowired
	Categorydao categoryDao;
	
	@RequestMapping("/adding")
	public String addPage()
	{return "adding";
	}
	
	@RequestMapping(value="/saveCat", method= RequestMethod.POST)
	@Transactional
	public ModelAndView saveCategory(@RequestParam("catId") int catId, @RequestParam("name") String name)
	{
		ModelAndView mav = new ModelAndView();
		Category c= new Category();
		c.setCatId(catId);
		c.setName(name);
		CategoryDAO.insertCategory(c);
		mav.setViewName("index");
		return mav;
	}
	
}*/