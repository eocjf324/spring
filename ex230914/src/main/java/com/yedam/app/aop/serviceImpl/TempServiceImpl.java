package com.yedam.app.aop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.TempMapper;
import com.yedam.app.aop.service.TempService;

@Service
public class TempServiceImpl implements TempService {

	@Autowired
	TempMapper tempMapper;
	
	//트랜잭션 어노테이션은 Service 밑에서만가능 AOP라서..
	@Transactional
	@Override
	public void insert(String value) {
		tempMapper.insert("101");
		tempMapper.insert("a101");

	}

}
