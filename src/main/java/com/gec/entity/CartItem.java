package com.gec.entity;

//购物车中每一项（每个商品的信息）
public class CartItem {
	//购物车中商品的详细信息
	private Product product;
	//购物车中商品的购买数量
	private int buyNum;
	//购物车中用户购买的商品的总价格
	private double subTotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public double getSubTotal() {
		return product.getShop_price()*buyNum;
	}
	
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", buyNum=" + buyNum + ", subTotal=" + subTotal + "]";
	}
	
	

}
