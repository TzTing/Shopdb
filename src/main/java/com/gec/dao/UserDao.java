package com.gec.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gec.entity.User;
import com.gec.utils.C3P0Utils;

public class UserDao {
	QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
	
	public User findUserByUsernameAndPassword(String username,String password) throws SQLException{
		String[] arg = {username,password};
		@SuppressWarnings("deprecation")
		User user = qr.query("select * from user where username =? and password=?"
				, arg
				,new BeanHandler<>(User.class));
				
				return user;

     }
	
}
