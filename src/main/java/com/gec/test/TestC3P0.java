package com.gec.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.gec.dao.UserDao;
import com.gec.entity.User;
import com.gec.utils.C3P0Utils;


public class TestC3P0 {

	@Test
	public void test() throws Exception{
		//使用C3P0数据库工具类
		Connection connection = C3P0Utils.getConnection ();
		System.out.println(connection);
		Statement statement =  connection.createStatement();
		ResultSet set = statement.executeQuery("select * from category");
		while(set.next()) {
			System.out.println(set.getInt(1)+"\t\t\t"+set.getString(2));
			
		}
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//queryRunner.query(sql,rsh)
	}
	@Test
	public void testQR() throws SQLException{
		QueryRunner qr =new QueryRunner(C3P0Utils.getDataSource());
//		User user = qr.query("select * from user", new BeanHandler<>(User.class));
//		System.out.println(user);
		List<User> users =  qr.query("select * from user"
				, new BeanListHandler<>(User.class));
		for (User user:users) {
			System.out.println(user);
		}
}
	@Test
	public void  testFind() throws SQLException {
		UserDao userDao =new UserDao();
		User user =userDao.findUserByUsernameAndPassword("ccc", "ccc");
		System.out.println(user);
		User user1 = userDao.findUserByUsernameAndPassword("ccc123", "ccc12312");
		System.out.println(user1);
	}
}
