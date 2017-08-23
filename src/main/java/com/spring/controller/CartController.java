package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.dao.CartDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Cart;
import com.spring.model.Product;

@Controller
public class CartController {
	
	
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	Cart cart;

	
	
    @RequestMapping(value="addToCart/{id}")
    public String addProductToCart(@PathVariable("id") int id, HttpSession session,Model model)
    {
    	int userId = (Integer) session.getAttribute("userid");
    	int q=1;
    	if (cartDAO.getitem(id, userId) != null) {
			Cart item = cartDAO.getitem(id, userId);
			item.setProductQuantity(item.getProductQuantity() + q);
			Product p = productDAO.getProductById(id);
			System.out.println(item);
			item.setProductPrice(p.getPrice());
			model.addAttribute("message", p.getName() +"is already exist");
			item.setSubTotal(item.getProductPrice() + (q*p.getPrice()));
			cartDAO.saveProductToCart(item);
			return "cart";
		} else {
			Cart item = new Cart();
			Product p = productDAO.getProductById(id);
			item.setProductid(p.getId());
			item.setProductName(p.getName());
			item.setUserId(userId);
			item.setProductQuantity(q);
			item.setSubTotal(q * p.getPrice());
			item.setProductPrice(p.getPrice());
			cartDAO.saveProductToCart(item);
			return "redirect:/cart";
		}
    	
    }
    
    @RequestMapping(value="/cart")
    public String cartPage(Model model){
    	model.addAttribute("cart", new Cart());
    	model.addAttribute("cartList", cartDAO.list());
    	
    	return "CartPage";
    }

}