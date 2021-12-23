package com.gec.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gec.dao.ProductDao;
import com.gec.entity.CartItem;
import com.gec.entity.Product;

public class ProductService {
	
	ProductDao productDao = new ProductDao();
	
	public Map<String,List<Product>> getNewAndHotProduct(){
		try {
			//创建一个map容器来存放查询的数据
			Map<String,List<Product>> map =new HashMap<>();
			//分别查询出最热和最新商品
			List<Product> isHot = productDao.findProductByIsHot();
			List<Product> byNew = productDao.findProductByNew();
			//将他们都存放在map容器中
			map.put("isHot",isHot);
			map.put("byNew",byNew);
			return map;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Product getProductById(int pid) {
		try {
			Product product = productDao.findProductById(pid);
			return product;
		}catch(Exception e) {
			
		}
		return null;
	}

	//根据用户所选的商品和商品编号去产生一条购物车的记录
	public CartItem getCartItem(int pid, int buyNum) {
		CartItem cartItem =new CartItem();
		//获取商品的详细信息
		Product productById = this.getProductById(pid);
		cartItem.setProduct(productById);
		cartItem.setBuyNum(buyNum);
		return cartItem;
		
	}

	//根据用户输入的关键词寻找商品
	public Product getProductByName(String pname){
		Product product = null;
		try {
			product = productDao.findProductByName(pname);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
