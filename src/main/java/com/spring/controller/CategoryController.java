package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

@Controller
//@RequestMapping(value="admin")
public class CategoryController {


	 static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	/* 
	    @Autowired 
	    private MessageSource messageSource;*/
	 
	    @RequestMapping(value="/category",  method=RequestMethod.GET)
	    public String listOfCategory(@ModelAttribute("category") Category category,  BindingResult result,  
                Model model, 
                RedirectAttributes redirectAttrs) {
	        logger.info("IN: Cateagory/list-GET");
	 
	        List<Category> categoryList = categoryDAO.list();
	        model.addAttribute("categoryList", categoryList);
	        model.addAttribute("CategoryPageClicked", "true");
	        
	       return "AdminPage";
	    }
	     
	    @RequestMapping(value="saveCategory", method=RequestMethod.POST)
	    public String addingStrategy(@Valid @ModelAttribute("category") Category category, 
	                                 BindingResult result,  
	                                 Model model, 
	                                 RedirectAttributes redirectAttrs) {
	         
	        logger.info("IN: category/add-POST");
	 
	      /*  if (result.hasErrors()) {
	            logger.info("Category-add error: " + result.toString());
	            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.Category", result);
	            redirectAttrs.addFlashAttribute("category", category);
	            return "redirect:category";
	        } else {*/
	        	categoryDAO.saveCategory(category);
	            String message = "Category " + category.getId() + " was successfully added";
	            model.addAttribute("message", message);
	            return "redirect:/category";
	        
	    }	
	    
	   
		
	@RequestMapping("editcategory/{id}")
	public String editCategory(@PathVariable("id") int id, Model model,RedirectAttributes attributes) {
		System.out.println("editCategory");
		attributes.addFlashAttribute("category", this.categoryDAO.getCategoryById(id));
		return "redirect:/category";
	}
	@RequestMapping(value ="removecategory/{id}")
	public String removeCategory(@PathVariable("id") int id,RedirectAttributes attributes) throws Exception {
		categoryDAO.removeCategoryById(id);
		attributes.addFlashAttribute("DeleteMessage", "Category has been deleted Successfully");
		return "redirect:/category";
	}
	
}