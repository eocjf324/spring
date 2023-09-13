package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")//절대경로 
public class EmpMapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void getEmp() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId("100");
		
		EmpVO findVO = empMapper.getEmp(empVO);
		
		assertEquals(findVO.getLastName(), "King");
	}
	
	@Test
	public void print() {
		System.out.println("테스트!");
	}
}
