package com.gec.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gec.entity.Product;
import com.gec.utils.C3P0Utils;

public class ProductDao {
	
	//创建传输sql语句和处理响应结果的对象queryRunner
	QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	
	
	//执行sql语句查询热门商品
	public List<Product> findProductByIsHot() throws Exception{
		List<Product> list =queryRunner.query("select * from product where is_hot =1", 
				new BeanListHandler<>(Product.class));
		return list;
	}
	public List<Product> findProductByNew() throws Exception{
		List<Product> list = queryRunner.query("select * from product order by pdate desc limit 16",
				new BeanListHandler<>(Product.class));
		return list;
	}


	//通过商品编号查询商品信息的方法
	public Product findProductById(int pid) throws Exception{
		Product product = queryRunner.query("select * from product where pid = ?", 
				pid,
				new BeanHandler<>(Product.class));
		return product;
	}

	//通过商品名字查询商品信息的方法
	public Product findProductByName(String pname) throws SQLException {
		Product product = queryRunner.query("select * from product where pname = ?",
				pname,
				new BeanHandler<>(Product.class));

		return product;
	}

}
