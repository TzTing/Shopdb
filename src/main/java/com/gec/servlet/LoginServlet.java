package com.gec.servlet;

import com.gec.entity.Product;
import com.gec.entity.User;
import com.gec.service.ProductService;
import com.gec.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用数据库访问层并判断账号密码是否正确
        User user = userService.login(username,password);
        if (user!=null){
            //正确 存入session
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("IndexServlet");
        }else{
            //错误回去 登录页面重新登录s
            request.setAttribute("error","输入出错");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }

    }
}