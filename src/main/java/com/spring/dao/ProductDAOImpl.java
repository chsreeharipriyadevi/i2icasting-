package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Product;

@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Product> list() {
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		return listProduct;
	}

	
	/*@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCategory;
	}*/

	
	
	@Transactional
	public Product getProductById(int product_id) {
		String hql = "from" + " Product" + " where id=" + product_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}

		return null;
	}

	@Transactional
	public Product removeProducyById(int product_id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(product_id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		return ProductToDelete;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProductByCategory(int category_id) {
		String hql = "from" + " Product" + " where id=" +category_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return (List<Product>) listProduct.get(0);
		}


		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Product> getProductByCategoryID(int category_id) {
		
		String hql = "from Product where category_id= "+category_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> catproducts = (List<Product>) query.list();
		return catproducts;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Product> navproduct(int category_id) {
		String hql = "from Product where category_id= "+category_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> catproducts = (List<Product>) query.list();
		return catproducts;
	}

}