package com.spring.dao;

import java.util.List;

import com.spring.model.Users;

public interface UserDAO {
	
	  public boolean saveOrUpdate(Users user);
	  public List<Users> list();
	  public Users getUserById(int user_id);
	  public void removeUserById(int user_id);
	  
	  public Users get(String email);
	}
