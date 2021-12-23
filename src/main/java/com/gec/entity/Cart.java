package com.gec.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cart {
	//使用一个map容器来存放多少商品
	private Map<String,CartItem> cartItems=new HashMap<String,CartItem>();
	//购物车里面商品的总价
	private double total;

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotal() {
		total=0;
		Set<Entry<String, CartItem>> set = cartItems.entrySet();
		for(Entry<String, CartItem> c:set){
			total+=c.getValue().getSubTotal();
		}
		return total;
	}
	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", total=" + total + "]";
	}
	
	
	
	
}
