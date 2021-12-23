package com.gec.servlet;

import com.gec.dao.UserDao;
import com.gec.entity.Cart;
import com.gec.entity.Order;
import com.gec.entity.User;
import com.gec.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SubmitOrderServlet", value = "/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");

        if (user == null){
            response.sendRedirect("login.jsp");
            return;
        }

        //登录状态下的提交订单
        OrderService orderService = new OrderService();
        Order order = orderService.createOder(user,cart);
        request.setAttribute("order",order);
        request.getRequestDispatcher("order_info.jsp").forward(request,response);



    }


}
