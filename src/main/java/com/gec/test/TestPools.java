package com.gec.test;


import java.util.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.gec.entity.User;
import com.gec.utils.C3P0Utils;


public class TestPools {
	
	@Test
	public void test() throws Exception{
		
			QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
			System.out.println(queryRunner);
			List<User> users = new ArrayList<>();
			User user = queryRunner.query("select * from user", new BeanHandler<>(User.class));
			System.out.println("-------------->");
			 System.out.println(user);
	}

}
