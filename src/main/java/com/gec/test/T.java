package com.gec.test;

import com.gec.dao.ProductDao;
import com.gec.entity.Product;
import com.gec.service.ProductService;

import java.util.List;

public class T {
    public static void main(String[] args) throws Exception {

        ProductDao productDao = new ProductDao();
        List<Product> products =  productDao.findProductByIsHot();
        for (int i = 0; i < products.size(); i++){
            System.out.println(products.get(i).getPname());
        }

    }
}
