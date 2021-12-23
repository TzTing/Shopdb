package com.gec.servlet;

import com.gec.entity.Product;
import com.gec.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/*
* 用户根据商品编号来查询商品信息的请求
*
*
* */

@WebServlet(name = "ProductInfoServlet", value = "/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取商品的id
        String parameter = request.getParameter("pid");
        int pid = Integer.parseInt(parameter);

        //2.调用service层代码 将商品信息放入request作用域中
        Product product = productService.getProductById(pid);
        request.setAttribute("product",product);

        //将数据转发到product_info.jsp首页中显示出来 重定向
        request.getRequestDispatcher("product_info.jsp").forward(request, response);

    }

}
