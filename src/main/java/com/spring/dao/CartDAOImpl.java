package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;


@Repository
public class CartDAOImpl implements CartDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean saveProductToCart(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	
	@SuppressWarnings("deprecation")
	@Transactional
	public Cart getitem(int prodId, int userId) {
		String hql = "from"+" Cart"+" where userid="+userId+" and productid="+prodId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

     @Transactional
     @SuppressWarnings({ "unchecked", "deprecation" })
	public List<Cart> list() {
		List<Cart> listCart = (List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listCart;
		
	}


     @Transactional
 	public Cart getCartById(int cart_id) {
  		String hql = "from" + " Cart" + " where id=" + cart_id;
 		@SuppressWarnings("rawtypes")
 		Query query = sessionFactory.getCurrentSession().createQuery(hql);

 		@SuppressWarnings("unchecked")
 		List<Cart> list = (List<Cart>) query.list();

 		if (list != null && !list.isEmpty()) {
 			return list.get(0);
 		}
 		return null;
 	}


     @Transactional
 	public Cart removeCartById(int cart_id) {
 		Cart CartToDelete = new Cart();
 		CartToDelete.setId(cart_id);
 		sessionFactory.getCurrentSession().delete(CartToDelete);
 		return CartToDelete;
 		
 	}


}