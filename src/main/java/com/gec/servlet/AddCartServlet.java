package com.gec.servlet;

import com.gec.entity.Cart;
import com.gec.entity.CartItem;
import com.gec.entity.Product;
import com.gec.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/*
* 创建一个session存放购物车的商品信息
*
* 购物车里可能有多个商品多个product 使用map容器来存放多个商品信息
*
* 根据用户提交过来的商品编号去活得商品信息 记录用户购买了多少商品
* AddCartServlet?pid=13&buyNum=1
*
* 用户添加数据进入购物车
* 1.购物车中有商品的情况
*  购物车中有商品 追加商品信息来到购物车
*  没有商品 创建一个购物车对象来存放商品信息
*
* 更新session中的购物车数据
*
* */

@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取商品的id 根据用户添加的商品编号去查询被添加进购物车的详细的商品信息
        String parameter = request.getParameter("pid");
        int pid = Integer.parseInt(parameter);

        String parameter2 = request.getParameter("buyNum");
        int buyNum = Integer.parseInt(parameter2);

        //查询用户选中的商品的详细信息并创建购物车的那一行数据信息
        CartItem cartItem = productService.getCartItem(pid,buyNum);

        //判断session中有没有购物车信息
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //如果第一次访问购物车创建购物车对象
        if (cart == null){
            cart = new Cart();
        }
        //将刚创建好的购物车一行数据放入购物车中
        Map<String ,CartItem> cartItems = cart.getCartItems();
        cartItems.put(request.getParameter("pid"),cartItem);

        //更新购物车中的数据
        session.setAttribute("cart",cart);

        //跳转到购物车页面
        response.sendRedirect("cart.jsp");
    }

}
