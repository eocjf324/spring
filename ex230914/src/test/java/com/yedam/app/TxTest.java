package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.aop.service.TempService;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class TxTest {
	@Autowired
	TempService tempService;
	
	@Test
	public void insert() {
		tempService.insert(null);
	}
	
	@Autowired
	EmpService empService;
	
	@Test
	public void empTest() {
		
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		empService.getEmp(empVO);
	}
}
