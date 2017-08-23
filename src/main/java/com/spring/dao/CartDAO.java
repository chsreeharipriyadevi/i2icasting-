	package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;

public interface CartDAO {
	
	
	public boolean saveProductToCart(Cart cart);
	
	public Cart getitem(int prodId,int userId);
	
	public List<Cart> list();
	

}