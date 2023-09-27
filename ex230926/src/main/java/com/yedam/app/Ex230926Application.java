package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")
public class Ex230926Application { //변경 놉!

	public static void main(String[] args) {
		SpringApplication.run(Ex230926Application.class, args);
	}

}
