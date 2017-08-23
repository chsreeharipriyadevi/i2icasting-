package com.spring.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Users;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public boolean saveOrUpdate(Users user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
		
	}

	public List<Users> list() {
		
		return null;
	}

	public Users getUserById(int user_id) {
		
		return null;
	}

	public void removeUserById(int user_id) {
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public Users get(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Users.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<Users> listUser = (List<Users>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}


}