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

import com.spring.dao.SupplierDAO;

import com.spring.model.Supplier;
@Controller
//@RequestMapping(value="admin")
public class SupplierController {

	
	 static Logger logger = LoggerFactory.getLogger(SupplierController.class);
	@Autowired
	SupplierDAO supplierDAO;
	
	
    @RequestMapping(value="/supplier",  method=RequestMethod.GET)
    public String listOfSupplier(@ModelAttribute("supplier") Supplier supplier,  BindingResult result,  
            Model model, 
            RedirectAttributes redirectAttrs) {
        logger.info("IN: Supplier/list-GET");
 
        List<Supplier> supplierList = supplierDAO.list();
        model.addAttribute("supplierList", supplierList);
        model.addAttribute("SupplierPageClicked", "true");
        
       return "AdminPage";
    }
    
    
	  @RequestMapping(value="saveSupplier", method=RequestMethod.POST)
	    public String addingStrategy(@Valid @ModelAttribute("supplier") Supplier supplier, 
	                                 BindingResult result,  
	                                 Model model, 
	                                 RedirectAttributes redirectAttrs) {
	         
	        logger.info("IN: supplier/add-POST");
	 
	      /*  if (result.hasErrors()) {
	            logger.info("Category-add error: " + result.toString());
	            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.Category", result);
	            redirectAttrs.addFlashAttribute("category", category);
	            return "redirect:category";
	        } else {*/
	        supplierDAO.saveSupplier(supplier);
	            String message = "Supplier " + supplier.getId() + " was successfully added";
	            model.addAttribute("message", message);
	            return "redirect:/supplier";
	        
	    }	

	
	
	
	
	@RequestMapping("editsupplier/{id}")
	public String editSupplier(@PathVariable("id") int id, Model model,RedirectAttributes attributes) {
		System.out.println("editCategory");
		attributes.addFlashAttribute("supplier", this.supplierDAO.getSupplierById(id));
		return "redirect:/supplier";
	}
	@RequestMapping(value = "removesupplier/{id}")
	public String removeSupplier(@PathVariable("id") int id,RedirectAttributes attributes) throws Exception {
		supplierDAO.removeSupplierById(id);
		attributes.addFlashAttribute("DeleteMessage", "supplier has been deleted Successfully");
		return "redirect:/supplier";
	}
	
}