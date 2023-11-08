package com.yedam.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired	OrdersDAO dao;
	
	@Override
	public int insertOrders(List<Orders> orders) {
		int cnt = 0;
		//테이블 입력
		
		
		return cnt; // 처리 건수 리턴;
	}

}
