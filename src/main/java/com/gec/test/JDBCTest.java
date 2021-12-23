package com.gec.test;

import jdk.nashorn.internal.ir.WhileNode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	//数据库地址
	static final String URL = "jdbc:mysql://localhost:3306/shopdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//数据库连接驱动
	static final String Driver_RNAME = "com.mysql.cj.jdbc.Driver";
	//数据库账号、密码
	static final String USERNAME = "root";
	static final String PASSWORD="1234";


	public static void main(String[] args) throws Exception {
		//编写Java连接访问数据的代码

		//加载数据库连接
		Class.forName(Driver_RNAME);
		//传入账号密码、数据库地址连接数据库
		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		//用来搬运传输数据库语句的工具
		Statement statement = connection.createStatement();
		//传入需执行的sql语句,得到处理结果resultset 结果集 存放了所有的查询结果的对象
		ResultSet rs = statement.executeQuery("select name,email from user");
		//得到数据库处理的结果
		//使用结果集内的游标 遍历结果集中的数据 展示处理结果
		System.out.println("姓名\t\t\t邮箱");
		while (rs.next()){ //next方法是用来移动结果集里面的游标判断里面有没有数据（游标会一行一行地去判断数据）
			System.out.print(rs.getString("name")+"\t\t\t");
			System.out.print(rs.getString("email"));
			System.out.println();
		}

		//关闭数据库连接
		rs.close();
		statement.close();
		connection.close();
	}


}
