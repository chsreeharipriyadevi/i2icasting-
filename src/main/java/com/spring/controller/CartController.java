package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			return "redirect:/cart";
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
    public String cartPage(Model model,HttpSession session){
    	model.addAttribute("cart", new Cart());
    	model.addAttribute("cartList", cartDAO.list());
    	//model.addAttribute("cartprice", cartDAO.CartPrice((Integer) session.getAttribute("userid")));
    	
    	return "CartPage";
    }
    
  
	@RequestMapping(value="removeCart/{id}",method=RequestMethod.GET)
	public String removeProduct(@PathVariable("id") int id,RedirectAttributes attributes)
	{
		cartDAO.removeCartById(id);
		attributes.addFlashAttribute("DeleteMessage", "Cart item has been deleted Successfully");
		return "redirect:/cart";
	   }
	
	 @RequestMapping("editCart/{id}")
		public String editorder(@PathVariable("id") int id, @RequestParam("productQuantity") int q, HttpSession session) {
			Cart cart = cartDAO.getCartById(id);
			Product product = productDAO.getProductById(cart.getProductid());
			System.out.println("cartlist==="+cart.getProductid());
			System.out.println("productlist="+product);
			cart.setProductQuantity(q);
			cart.setProductPrice(q * product.getPrice());
			cartDAO.saveProductToCart(cart);
			//session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
			return "redirect:/cart";
		}

	 @RequestMapping(value="/checkoutpage")
	 public String checkoutPage (Model model){
		 model.addAttribute("cart", new Cart());
		 model.addAttribute("cartList", cartDAO.list()); 
		 return "CheckoutPage";
	 }
	 
	 @RequestMapping(value="/cash")
	 public String EnterAddress (Model model){
		 model.addAttribute("cart", new Cart());
		 model.addAttribute("cartList", cartDAO.list()); 
		 return "cod";
	 }
	 
	 @RequestMapping(value="/Success")
		public String SuccessPage(Model model) {
		
			model.addAttribute("Clickedcatproduct", "true");
			return "success";
		}


}