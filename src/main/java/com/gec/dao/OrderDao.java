package com.gec.dao;

import com.gec.entity.Order;
import com.gec.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class OrderDao {
    //创建传输sql语句和处理响应结果的对象queryRunner
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    public int addOrder(Order order){
        int n=0;
        try {
            String sql="insert into orders values(?,now(),?,?,?,?,?,?,null)";
            String[] args={order.getOid(),String.valueOf(order.getTotal()),String.valueOf(order.getState()),
                    order.getAddress(),order.getName(),order.getTelephone(),order.getUid()};
            n = queryRunner.update(sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;

    }




}
