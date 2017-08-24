package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;
import com.spring.model.Product;

public interface CartDAO {

	public boolean saveProductToCart(Cart cart);

	public Cart getitem(int prodId, int userId);

	public Cart getCartById(int cart_id);

	public Cart removeCartById(int cart_id);

	public List<Cart> list();

	public double CartPrice(int userId);

}