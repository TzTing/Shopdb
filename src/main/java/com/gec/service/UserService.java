package com.gec.service;

import java.sql.SQLException;

import com.gec.dao.UserDao;
import com.gec.entity.User;

public class UserService{
	
	UserDao userDao =new UserDao();
	
	public User login(String username,String password) {
		try {
			User user = userDao.findUserByUsernameAndPassword(username, password);
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
