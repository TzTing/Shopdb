package com.gec.dao;

import com.gec.entity.Order;
import com.gec.entity.OrderItem;
import com.gec.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

public class OrderItemDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    public void addOrderItem(OrderItem orderItem){
        try {
            String sql = "insert into orderitem values(?,?,?,?,?)" ;
            Object args[] = {orderItem.getItemId(),orderItem.getCount(),
                    orderItem.getSubtotal(),orderItem.getProduct().getPid(),orderItem.getOid()};
            queryRunner.update(sql,args);

        }catch (Exception e){

        }



    }



}
