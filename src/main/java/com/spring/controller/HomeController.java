package com.spring.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.dao.UserDAO;
import com.spring.model.Product;
import com.spring.model.Users;

@Controller
public class HomeController {

	 static Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	UserDAO userDAO;
	
	

    @RequestMapping(value="/",  method=RequestMethod.GET)
    public String homePage(HttpSession session,Model m)
    {
    	session.setAttribute("categoryList", categoryDAO.list());
    	session.setAttribute("ProductList",productDAO.list());
    	m.addAttribute("UserClickedshowproduct","true");
    	/*session.setAttribute("ListProduct", productDAO.getProductByCategoryID(id));
    	*/
    	
       return "WelcomePage";
    }
	
    @RequestMapping("/login")
    public String login(@RequestParam(value="error",required=false) String error,
    		@RequestParam(value="logout",required=false) String logout,
    		Model model){
    	if(error!=null)
    		model.addAttribute("error","Invalid Username and Password.. Please enter valid username and password");
    	if(logout!=null)
    		model.addAttribute("logout","Loggedout successfully");
    		model.addAttribute("LoginPageClicked", true);
    	return "WelcomePage";
    	
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userDAO.get(email);
		session.setAttribute("userid", user.getId());
		session.setAttribute("name", user.getEmail());
		session.setAttribute("LoggedIn", "true");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 /*session.setAttribute("cartsize",cartDAO.cartsize((Integer)session.getAttribute("userid")));*/
		    	 return "redirect:/";
		     }
		     else 
		     {
		    	 session.setAttribute("Administrator", "true");
		    	 model.addAttribute("product",  new Product());
		    	 model.addAttribute("ProductPageClicked", "true");
		    	 model.addAttribute("supplierList",supplierDAO.list());
		    	 model.addAttribute("categoryList",categoryDAO.list());
			 return "/AdminPage";
		     }
	}
		return "/WelcomePage";
	
	}
    
    
    
    
    
    @RequestMapping(value = "register")
	public String DisplayRegister(Model mv) {
		mv.addAttribute("user", new Users());
		mv.addAttribute("IfRegisterClicked", "true");

		return "WelcomePage";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String UserRegister(@ModelAttribute("user") Users user,RedirectAttributes attributes) {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		attributes.addFlashAttribute("SuccessMessage","Registration Successfull");
		return "redirect:register";
	}
	
	@RequestMapping(value = "navproducts/${id}")
	public String listCategory(Model model,@PathVariable("id") int id,RedirectAttributes attributes) {
	
		model.addAttribute("navproducts", productDAO.getProductByCategory(id));
		model.addAttribute("Clickedcatproduct", "true");
		return "catproducts";
	}
	
/*
	  @RequestMapping(value ="nav/{id}" )
	    public String ShowProduct(@PathVariable("id") int id,RedirectAttributes attributes,Model m) {
	        m.addAttribute("UserClickedshowproduct", "true");
	        attributes.addFlashAttribute("PList", productDAO.getProductByCategoryID(id));
	        return "redirect:/";
	    }
*/	
	
	
	
@RequestMapping(value ="nav/{id}" )
public String ShowProductByCategory(@PathVariable("id") int id,RedirectAttributes attributes,Model m) {
	
	logger.info("Listing the Product by Category ID:");
    attributes.addFlashAttribute("PList", productDAO.getProductByCategoryID(id));
    logger.info("Listed the product by Category ID:"+id);
    return "redirect:/";
}

}