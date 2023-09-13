package com.yedam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	
	public static void main(String[] args) {
		//스프링 실행 빈에 등록되면서 xml을 불러온다?
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		//NEW 연산자X 
		Mail mail = (Mail)ctx.getBean("mail");
		mail.printMessage();
	}

}
