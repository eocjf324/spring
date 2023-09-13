package com.yedam.app.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	@Autowired //필드위에 동작시킴  전제조건은 bean 적어도 하나 필요 /해당 타입의 객체를 찾아서 자동으로 할당
	Chef chef;
	
	@Autowired  // 개별 autowired 선언해줘야함
	TV tv;
	
	public void open() {
		chef.cooking();
	}
	

}
