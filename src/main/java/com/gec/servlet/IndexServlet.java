package com.gec.servlet;

import com.gec.entity.Product;
import com.gec.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1111111");
        //查询出主页的最新商品和最热商品信息
        ProductService productService = new ProductService();
        //调用service层代码 从map中取出最热、最新商品后放入request作用域中
        Map<String, List<Product>> map = productService.getNewAndHotProduct();
        List<Product> ishot  = map.get("isHot");
        List<Product> byNew  = map.get("byNew");

        request.setAttribute("hotProductList",ishot);
        request.setAttribute("newProductList",byNew);
        //将数据转发到index.jsp首页中显示出来
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

}
