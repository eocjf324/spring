package com.yedam.app;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class EncrytionTest {
	
	@Autowired
	StandardPBEStringEncryptor encryptor;
	
	@Test
	public void enryptionTest() {
		String[] dataList = {
								"net.sf.log4jdbc.sql.jdbcapi.DriverSpy",
								"jdbc:log4jdbc:oracle:thin:@127.0.0.1:1521:xe",
								"hr",
								"1234"
							};
		
		for(String data : dataList) {
			String encData = encryptor.encrypt(data);
			System.out.println(encData);
		}
	}
}
