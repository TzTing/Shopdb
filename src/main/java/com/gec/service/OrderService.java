package com.gec.service;

import com.gec.dao.OrderDao;
import com.gec.dao.OrderItemDao;
import com.gec.entity.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.scene.layout.BorderImage;
import netscape.security.UserTarget;

import java.util.*;

public class OrderService {
    OrderDao orderDao = new OrderDao();
    OrderItemDao orderItemDao = new OrderItemDao();

    public Order createOder(User user, Cart cart){
        //设置订单对象和参数
        Order order =new Order();
        order.setOid(UUID.randomUUID().toString());
        order.setAddress(user.getAddress());
        order.setName(user.getName());
        order.setOrderTime(new Date());
        order.setState(0);
        order.setTelephone(user.getTelephone());
        order.setUid(user.getUid());
        orderDao.addOrder(order);

        //设置订单明细
        List<OrderItem> orderItems = new ArrayList<>();
        Map<String, CartItem>cartItems = cart.getCartItems();
        Set<Map.Entry<String,CartItem>>entrySet = cartItems.entrySet();
        Iterator<Map.Entry<String,CartItem>>iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,CartItem> entry = iterator.next();
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(cartItem.getBuyNum());
            orderItem.setItemId(UUID.randomUUID().toString());
            orderItem.setProduct(cartItem.getProduct());
            orderItems.add(orderItem);
            orderItemDao.addOrderItem(orderItem);
        }
        order.setOrderItems(orderItems);
        return order;
    }



}
