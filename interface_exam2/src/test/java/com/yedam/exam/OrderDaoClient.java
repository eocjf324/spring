package com.yedam.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class OrderDaoClient {
	
	@Autowired OrdersDAO dao;
	
	@Test
	public void test() {
		Orders orders = new Orders();
		orders.setOrd_no(1);
		orders.setCustomer("james");
		orders.setOrd_goods("g1");
		orders.setOrd_cnt(5);
		orders.setOrd_price(2500);
		int r = dao.insertOrders(orders);
		System.out.println(r+"건 처리됨");
    }
}
